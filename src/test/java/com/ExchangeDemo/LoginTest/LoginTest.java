package com.ExchangeDemo.LoginTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ExchangeDemo.LoginPage.LoginPage;
import com.ExchangeDemo.LoginPage.MyAccountPage;

import Resources.BaseClass;

public class LoginTest extends BaseClass {

	Logger log;
	public WebDriver driver;

	@Test(dataProvider = "LoginTestData") // LoginTestData
	// @Test(dataProvider = "loginData")
	public void login(String userName, String passWord, String expectedResult)
			throws IOException, InterruptedException {

		// log = LogManager.getLogger(LoginTest.class.getName());
		LoginPage loginpage = new LoginPage(driver);
		// loginpage.mylogin().click();
		// log.debug("Clicked on Login");
		Thread.sleep(3000);
		// loginpage.email().sendKeys(prop.getProperty(userName));
		// loginpage.password().sendKeys(prop.getProperty(passWord));
		// loginpage.email().sendKeys(userName);
		loginpage.mobile().sendKeys(userName);
		log.debug("Mobile Number is entered");
		loginpage.password().sendKeys(passWord);
		log.debug("Password is entered");
		Thread.sleep(3000);
		// loginpage.Continue().click();
		loginpage.login().click();
		log.debug("Clicked on login button");

		Thread.sleep(3000);

		MyAccountPage account = new MyAccountPage(driver);
		String actualResult = null;

		try {
			if (account.myAccount().isDisplayed()) {
				actualResult = "Success";
			}
		} catch (Exception e) {
			actualResult = "Failure";
		}

		String logMessage = "User got ";

		if (actualResult.equals("Success")) {
			logMessage += "successfully logged in using Username: " + userName + " and Password: " + passWord;
		} else {
			logMessage += "failed to log in using Username: " + userName + " and Password: " + passWord;
		}

		// Reporter.log(logMessage);
		Reporter.log("<font color='dark green'>" + logMessage + "</font>");

		// Reporter.log("Test executed with the following data: Username: " + userName +
		// ", Password: " + passWord + ", Expected Result: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
		log.info("Login Test got closed");
	}

	@BeforeMethod
	public void openApplication() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = intialaizeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to Application URL");

	}

	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");

	}

	@DataProvider(name = "LoginTestData")
	// @DataProvider()
	public Object[][] loginData() {
		Object[][] data = new Object[6][3];

		data[0][0] = "8660327769";
		data[0][1] = "123456";
		data[0][2] = "Success";

		data[1][0] = "8660327769";
		data[1][1] = "11";
		data[1][2] = "Failure";

		data[2][0] = "8660327763";
		data[2][1] = "123456";
		data[2][2] = "Failure";

		data[3][0] = "8660327769";
		data[3][1] = "";
		data[3][2] = "Failure";

		data[4][0] = " ";
		data[4][1] = "12346";
		data[4][2] = "Failure";

		data[5][0] = " ";
		data[5][1] = "";
		data[5][2] = "Failure";

		return data;

	}

}
