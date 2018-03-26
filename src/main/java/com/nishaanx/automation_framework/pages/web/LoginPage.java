package com.nishaanx.automation_framework.pages.web;

import org.openqa.selenium.By;

/**
 *
 * @author abc
 */
public class LoginPage extends BasePage {

    By username = By.xpath("//input[@type='text' and preceding-sibling::label[text()='Username']]");
    By password = By.xpath("//input[@type='password' and preceding-sibling::label[text()='Password']]");
    By submit = By.xpath("//input[@value='Login']");

    public LoginPage enterUserName(String username) {
        waitForElement(this.username).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        waitForElement(this.password).sendKeys(password);
        return this;
    }

    public <T extends BasePage> T clickSubmit(Class<T> clazz) {
        waitForElement(submit).click();
        try {
            return (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new AssertionError("Unable to create a page for the generic class");
        }
    }

    public boolean isLoginPageDisplayed() {
        return isElementPresent(username);
    }
}
