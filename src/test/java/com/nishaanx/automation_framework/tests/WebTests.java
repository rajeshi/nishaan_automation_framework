package com.nishaanx.automation_framework.tests;

import com.nishaanx.automation_framework.data.WorkflowInfo;
import com.nishaanx.automation_framework.enums.WorkflowEnums;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebTests extends BaseTests {

    @Test(dataProvider = "testData")
    public void testCreationOfAWorkflow(WorkflowInfo workflowInfo) {
        //      NishaanxWorkflows nw = new NishaanxWorkFlowImplementations();
        System.out.println("Workflow printing");
    }

    @DataProvider(name = "testData", parallel = false)
    public static Object[][] getTestData() {
        List<List<WorkflowInfo>> workflows = new ArrayList<>();
        WorkflowEnums[] enums = WorkflowEnums.values();
        for (WorkflowEnums enum1 : enums) {
            List<WorkflowInfo> workflowInfo = new ArrayList<>();
            workflowInfo.add(enum1.getData());
            workflows.add(workflowInfo);
        }
        return (WorkflowInfo[][]) workflows.toArray();
    }
}
