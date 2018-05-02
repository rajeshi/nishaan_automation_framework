package com.nishaanx.automation_framework.utils;

import com.nishaanx.automation_framework.base.Res;
import com.nishaanx.automation_framework.data.WorkflowInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Rajesh
 */
public class Excel {

    public final ExcelContext context;
    private int rowOffset;
    private int columnOffset;

    public Excel(ExcelContext context) {
        this.context = context;
    }

    public int getRowOffset() {
        return rowOffset;
    }

    public void setRowOffset(int rowOffset) {
        this.rowOffset = rowOffset;
    }

    public int getColumnOffset() {
        return columnOffset;

    }

    public String[][] getData(String... columnNames) {
        return getExcelRecords(Res.getResource(((ExcelContext) context).getExcelFile()), columnNames);
    }

    public String getSheetName() {
        return ((ExcelContext) context).getSheetName();
    }

    private String[][] getExcelRecords(URL resource, String[] columnNames) {
        List<String[]> neededRows = new ArrayList<>();
        //JOptionPane.showInputDialog(resource);
        XSSFWorkbook workbook = getWorkbook(resource);
        XSSFSheet sheet = null;
        if (getSheetName() == null || getSheetName().isEmpty()) {
            sheet = workbook.getSheetAt(0);
        } else {
            sheet = workbook.getSheet(getSheetName());
        }
        setRowOffset(sheet.getFirstRowNum());
        setColumnOffset(sheet.getRow(getRowOffset()));
        List<String> columnHeaders = getColumnHeaders(sheet);
        List<Integer> neededIndexes = new ArrayList<>();

        if (columnNames == null || columnNames.length == 0) {
            for (int i = 0; i < columnHeaders.size(); ++i) {
                neededIndexes.add(getColumnOffset() + i);
            }
        } else {
            for (String neededName : columnNames) {
                int neededIndex = columnHeaders.indexOf(neededName);
                if (neededIndex < 0) {
                    throw new RuntimeException("Column Name: \"" + neededName + "\" was not found in the excel");
                }
                neededIndexes.add(getColumnOffset() + Integer.valueOf(neededIndex));
            }
        }

        int numNeededCols = neededIndexes.size();
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            XSSFRow row = (XSSFRow) rowIterator.next();
            if (row.getRowNum() <= sheet.getFirstRowNum()) {
            } else {
                Iterator<Cell> cellIterator = row.cellIterator();
                String[] neededRow = new String[numNeededCols];
                int rowCnt = 0;
                while (cellIterator.hasNext()) {
                    XSSFCell cell = (XSSFCell) cellIterator.next();
                    for (int i = 0; i < numNeededCols; i++) {
                        if (cell.getColumnIndex() == neededIndexes.get(i)) {
                            String cellValue = "";
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_BOOLEAN:
                                    cellValue = Boolean.toString(cell.getBooleanCellValue());
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:
                                    cellValue = Double.toString(cell.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    cellValue = cell.getStringCellValue();
                                    if (cellValue.trim().equalsIgnoreCase("<<blank>>")) {
                                        cellValue = "";
                                    }
                                    break;
                            }

                            if (cellValue.isEmpty() || cellValue == null) {
                            } else {
                                neededRow[rowCnt] = cellValue;
                            }
                            rowCnt++;
                        }
                    }
                }

                neededRows.add(neededRow);
            }
        }
        return neededRows.toArray(new String[neededRows.size()][]);
    }

    private List<String> getColumnHeaders(XSSFSheet sheet) {
        List<String> columnHeaders = new ArrayList<>();
        XSSFRow header = sheet.getRow(getRowOffset());
        Iterator<Cell> cellIterator = header.cellIterator();
        while (cellIterator.hasNext()) {
            XSSFCell cell = (XSSFCell) cellIterator.next();
            String headerVal = "";
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    headerVal = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    headerVal = Double.toString(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    headerVal = cell.getStringCellValue();
                    break;
            }
            if (headerVal.isEmpty() || headerVal == null) {
            } else {
                columnHeaders.add(headerVal);
            }
        }
        return columnHeaders;
    }

    private void setColumnOffset(XSSFRow row) {
        Iterator<Cell> cellIterator = row.cellIterator();
        XSSFCell cell = (XSSFCell) cellIterator.next();
        this.columnOffset = cell.getColumnIndex();
    }

    public XSSFWorkbook getWorkbook(URL resource) {
        XSSFWorkbook workbook = null;
        try {
            File file = new File(resource.toURI());
            FileInputStream fis = new FileInputStream(file);
            try {
                workbook = new XSSFWorkbook(fis);
            } catch (IOException ex) {
                throw new RuntimeException(
                        "Unable to open the file. Either the file is no present or you are pointing to an incorrect file url");
            }
        } catch (URISyntaxException | FileNotFoundException ex) {
            throw new RuntimeException("Unable to read the file or the url is incorrect");
        }
        return workbook;
    }

    public String getColumnDataByRowIndex(int rowIndex, String... columnName) {
        String[][] columnData = getExcelRecords(Res.getResource(((ExcelContext) context).getExcelFile()), columnName);
        return columnData[rowIndex][0];
    }

    public <T> List<T> getData(String[] columnNames, Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<T> neededRows = new ArrayList<>();
        XSSFWorkbook workbook = getWorkbook(Res.getResource(((ExcelContext) context).getExcelFile()));
        XSSFSheet sheet = null;
        if (getSheetName() == null || getSheetName().isEmpty()) {
            sheet = workbook.getSheetAt(0);
        } else {
            sheet = workbook.getSheet(getSheetName());
        }
        setRowOffset(sheet.getFirstRowNum());
        setColumnOffset(sheet.getRow(getRowOffset()));
        List<String> columnHeaders = getColumnHeaders(sheet);

        List<Integer> neededIndexes = new ArrayList<>();

        if (columnNames == null || columnNames.length == 0) {
            for (int i = 0; i < columnHeaders.size(); ++i) {
                neededIndexes.add(getColumnOffset() + i);
            }
        } else {
            for (String neededName : columnNames) {
                int neededIndex = columnHeaders.indexOf(neededName);
                if (neededIndex < 0) {
                    throw new RuntimeException("Column Name: \"" + neededName + "\" was not found in the excel");
                }
                neededIndexes.add(getColumnOffset() + Integer.valueOf(neededIndex));
            }
        }

        int numNeededCols = neededIndexes.size();
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            XSSFRow row = (XSSFRow) rowIterator.next();
            if (row.getRowNum() <= sheet.getFirstRowNum()) {
            } else {
                T obj = clazz.newInstance();
                int rowCnt = 0;
                for (int i = 0; i < numNeededCols; i++) {
                    String headerName = sheet.getRow(sheet.getFirstRowNum()).getCell(rowOffset).getRichStringCellValue().toString();
                    String cellValue = "";
                    Cell cell = row.getCell(i);
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            cellValue = Boolean.toString(cell.getBooleanCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            cellValue = Double.toString(cell.getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            cellValue = cell.getStringCellValue();
                            if (cellValue.trim().equalsIgnoreCase("<<blank>>")) {
                                cellValue = "";
                            }
                            break;
                    }

                    if (cellValue.isEmpty() || cellValue == null) {
                    } else {
                        for (Method method : obj.getClass().getDeclaredMethods()) {
                            if (method.getName().startsWith("set") && method.getName().equals("set" + headerName)) {
                                method.invoke(obj, cellValue);
                            }
                        }
                    }
                    neededRows.add(obj);
                }
            }
        }
        return neededRows;
    }

    public List<WorkflowInfo> getWorkflowData(URI filePath) throws FileNotFoundException, IOException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        File file = new File(filePath);

        FileInputStream fis = new FileInputStream(file);
        Workbook wb = new XSSFWorkbook(fis);
        List<WorkflowInfo> workflows = new ArrayList<>();
        List<Integer> allRowsInEachSheet = new ArrayList<>();
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            Sheet sheet = wb.getSheetAt(i);
            allRowsInEachSheet.add(sheet.getPhysicalNumberOfRows());
        }

        int maxRows = Collections.max(allRowsInEachSheet);
        for (int i = 2; i < maxRows; i++) {
            WorkflowInfo workflowInfo = new WorkflowInfo();
            for (int j = 0; j < wb.getNumberOfSheets(); j++) {
                Sheet sheet = wb.getSheetAt(j);
                String sheetName = sheet.getSheetName();
                if (sheetName.contains("MasterData")) {
                    continue;
                }
                String pkg = "com.nishaanx.automation_framework.data.";
                Class<?> clazz = Class.forName(pkg + sheetName.replace("Data", ""));
                for (Method method : WorkflowInfo.class.getDeclaredMethods()) {
                    if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
                        if (method.getReturnType().isAssignableFrom(clazz)) {
                            Class<?> innerClass = method.getReturnType();
                            Object innerClassInstance = innerClass.newInstance();
                            for (Method m : innerClass.getMethods()) {
                                if (m.getName().startsWith("set")) {
                                    Row rowHeader = sheet.getRow(1);
                                    for (int k = 1; k <= rowHeader.getPhysicalNumberOfCells(); k++) {
                                        Cell cell = (Cell) sheet.getRow(i).getCell(k);
                                        String methodName = m.getName().replace("set", "");
                                        System.out.println(methodName);
                                        if (methodName.equals(rowHeader.getCell(k).getStringCellValue().trim())) {
                                            String cellValue = "";
                                            if (cell == null) {
                                                cellValue = "";
                                            } else {
                                                //cell.setCellType(CellType.STRING);
                                                switch (cell.getCellTypeEnum()) {
                                                    case BOOLEAN:
                                                        cellValue = Boolean.toString(cell.getBooleanCellValue());
                                                        break;
                                                    case NUMERIC:
                                                        cell.setCellType(CellType.STRING);
                                                        cellValue = cell.getStringCellValue();
                                                        break;
                                                    case STRING:
                                                        cellValue = cell.getStringCellValue();
                                                        if (cellValue.trim().equalsIgnoreCase("<<blank>>")) {
                                                            cellValue = "";
                                                        }
                                                        break;
                                                    case FORMULA:
                                                        FormulaEvaluator eval = wb.getCreationHelper().createFormulaEvaluator();
                                                        CellValue cv = eval.evaluate(cell);
                                                        switch (cv.getCellTypeEnum()) {
                                                            case NUMERIC:
                                                                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                                                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                                                                    Date date = HSSFDateUtil.getJavaDate(cv.getNumberValue());
                                                                    cellValue = df.format(date);
                                                                } else {
                                                                    cellValue = String.valueOf(cv.getNumberValue()).replace(".0", "");
                                                                }
                                                                break;
                                                            default:
                                                                cellValue = cv.getStringValue();
                                                                break;
                                                        }
                                                        break;
                                                    default:
                                                        cell.setCellType(CellType.STRING);
                                                        cellValue = cell.getStringCellValue();
                                                }
                                            }
                                            if (m.getParameterTypes()[0].equals(Boolean.TYPE)) {
                                                if (cellValue.trim().equalsIgnoreCase("Yes")) {
                                                    m.invoke(innerClassInstance, true);
                                                } else {
                                                    m.invoke(innerClassInstance, false);
                                                }
                                            } else {
                                                m.invoke(innerClassInstance, m.getParameterTypes()[0].cast(cellValue));
                                            }
                                            System.out.println(rowHeader.getCell(k).getStringCellValue() + "==" + cellValue);
                                            break;
                                        }
                                    }
                                }
                            }
                            Method setterMethod = WorkflowInfo.class.getMethod("set" + method.getName().replace("get", "").replace("is", ""), method.getReturnType());
                            setterMethod.invoke(workflowInfo, (Object) innerClassInstance);
                        }
                    }
                }
            }
            workflows.add(workflowInfo);
        }
        return workflows;
    }
}
