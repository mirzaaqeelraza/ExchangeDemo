package com.ExchangeDemo.TennisPage;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.BaseClass;

public class TennisPage extends BaseClass {

	WebDriver driver;

	public TennisPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()=\"TENNIS\"]") 
	WebElement tennisnav;

	//public WebElement TennisNavLink() {
	  //	return  tennisnav;
	//}
	
	 public void navigateToTennisPage() {
	        tennisnav.click();
	    }

	 public boolean isTennisPageLoaded() throws TimeoutException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"TENNIS\"]"))) != null;
	    }

}