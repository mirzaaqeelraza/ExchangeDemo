package com.ExchangeDemo.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"userName\"]") 
	WebElement Mobile_Number;

	@FindBy(xpath = "//input[@name=\"password\"]")  
	WebElement Password;

	@FindBy(xpath = "//button[text()=\"LOGIN\"]")  
	WebElement login_Page;

	public WebElement mobile() {
		return  Mobile_Number;
	}

	public WebElement password() {
		return Password;
	}

	public WebElement login() {
		return login_Page;
	}

}

