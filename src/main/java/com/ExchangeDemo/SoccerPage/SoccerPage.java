package com.ExchangeDemo.SoccerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.BaseClass;

public class SoccerPage extends BaseClass {

	WebDriver driver;

	public SoccerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()=\"SOCCER\"]") 
	WebElement soccernav;

	@FindBy(xpath = "//input[@name=\"password\"]")  
	WebElement Password;

	@FindBy(xpath = "//button[text()=\"LOGIN\"]")  
	WebElement login_Page;

	public WebElement IngameNavLink() {
		return  soccernav;
	}

	public WebElement password() {
		return Password;
	}

	public WebElement login() {
		return login_Page;
	}

}