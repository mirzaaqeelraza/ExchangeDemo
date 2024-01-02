package com.ExchangeDemo.Tennis;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ExchangeDemo.LoginPage.LoginPage;
import com.ExchangeDemo.TennisPage.TennisPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Resources.BaseClass;

public class TennisTest extends BaseClass {

	Logger log;
	// WebDriver driver;

	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;

	@BeforeTest
	public void setup() {
		extent = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reportPath");
		extent.attachReporter(sparkReporter);
	}

	@BeforeClass
	public void openApplication() throws IOException {
		test = extent.createTest("Open Application"); // Create a test instance
		String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";
		driver = intialaizeDriver();
		test.log(Status.PASS, "Browser got launched");

		Reporter.log("<font color='green'>Browser got launched</font>");
		driver.get(prop.getProperty("url"));
		test.log(Status.PASS, "Navigated to Application URL");

		Reporter.log("<font color='green'>Navigated to Application UR</font>");
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.mobile().sendKeys(prop.getProperty("mobile"));
		test.log(Status.PASS, "Mobile Number is entered");
		Reporter.log("Email is entered");
		Thread.sleep(3000);
		loginpage.password().sendKeys(prop.getProperty("password"));
		test.log(Status.PASS, "Password is entered");
		Reporter.log("Password is Entered");
		Thread.sleep(3000);
		loginpage.login().click();
		Reporter.log("Clicked on Continue Button");
		test.log(Status.PASS, "Clicked on Login Button");
		Thread.sleep(6000);
	}

	/*@Test(priority = 2)
	public void MyAccount() throws InterruptedException {
		TennisPage tennis = new TennisPage(driver);
		//Thread.sleep(8000);
		//ingame.IngameNavLink().click();
		tennis.TennisNavLink().click();
		test.log(Status.PASS,
				"The \"Tennis\" navigation link has been clicked, leading to the navigation to the In Game page");
		Thread.sleep(10000);
	}   */
	
	@Test(priority = 2)
    public void MyAccount() throws InterruptedException {
        TennisPage tennisPage = new TennisPage(driver);
        tennisPage.navigateToTennisPage();

        // Wait for the page to load
        //waitForPageToLoad("expected_tennis_page_url");
        waitForPageToLoadUrlcontains("tennis");
        
        // Verify elements on the Tennis page
        try {
			if (tennisPage.isTennisPageLoaded()) {
			    test.log(Status.PASS, "The Tennis page has been successfully navigated to.");
			} else {
			    test.log(Status.FAIL, "The Tennis page has not loaded successfully.");
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
	@AfterClass
	public void closure() {
		driver.close();
		test.log(Status.PASS, "Browser got closed");
		Reporter.log("<font color='green'>Browser got closed</font>");
	}

	@AfterTest
	public void reportTeardown() {
		extent.flush();
	}

}

