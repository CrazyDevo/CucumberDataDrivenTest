package com.cydeo.stepdefs;


import com.cydeo.pages.CommonPages;
import com.cydeo.pages.LoginPage;
import com.cydeo.setup.TestBase;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LoginSteps {

	WebDriver driver;

	LoginPage loginPage;
	TestBase testBase;
	CommonPages commonPages;

	@Then("login to the application")
	public void login_to_the_application() {
		testBase = new TestBase();
		driver = testBase.getDriver();
		loginPage = new LoginPage(driver);
		commonPages = new CommonPages(driver);
		commonPages.launchApplication();
		assertEquals(loginPage.loginToApplication(), true);
	}

}
