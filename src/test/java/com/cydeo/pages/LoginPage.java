package com.cydeo.pages;


import com.cydeo.setup.TestBase;
import com.cydeo.stepdefs.CommonSteps;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = TestBase.getWebDriverWait();
    }

    WebDriver driver;
    WebDriverWait wait;

    ExcelReader excelReader;

    @FindBy(css="#prependedInput")
    public WebElement usernameInput;

    @FindBy(id="prependedInput2")
    public WebElement passwordInput;

    @FindBy(id="_submit")
    public WebElement loginBtn;
    @FindBy(id = "user-menu")
    WebElement userProfileIcon;
    public boolean loginToApplication() {
        boolean isLoginSuccess = false;
        excelReader = new ExcelReader(CommonSteps.row_number, CommonSteps.sheetName);
        usernameInput.sendKeys(CommonSteps.excelReader.fieldsAndValues.get("username"));
        passwordInput.sendKeys(CommonSteps.excelReader.fieldsAndValues.get("password"));
        loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(userProfileIcon));
        BrowserUtils.waitFor(3);
        isLoginSuccess = driver.getTitle().contains("Dashboard");
        return isLoginSuccess;
    }

}
