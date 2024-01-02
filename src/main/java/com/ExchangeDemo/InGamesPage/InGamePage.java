
package com.ExchangeDemo.InGamesPage;

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

public class InGamePage extends BaseClass {

	WebDriver driver;

	public InGamePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()=\"In Game\"]") 
	WebElement ingamenav;

	//public WebElement IngameNavLink() {
		//return  ingamenav;
	//}
	
	public void navigateToInGamePage() {
        ingamenav.click();
    }

 public boolean isIngamePageLoaded() throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"In Game\"]"))) != null;
    }

}