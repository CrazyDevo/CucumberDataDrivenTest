package com.cydeo.pages;


import com.cydeo.setup.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPages extends TestBase {

	WebDriver driver;
	WebDriverWait wait;
	

	public CommonPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = TestBase.getWebDriverWait();
	}
	
	public void launchApplication() {
		driver.get(TestBase.url);
	}
	
	
}
