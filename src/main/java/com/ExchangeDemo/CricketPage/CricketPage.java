package com.ExchangeDemo.CricketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.BaseClass;

public class CricketPage extends BaseClass {

	WebDriver driver;

	public CricketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()=\"CRICKET\"]") 
	WebElement cricketnav;

	
// //div[@class='cardLayout_matchData_Container__gJaPS']//div[@class='button_btn_container___X3yi ']//button[1]//div[@class='button_price__cBFNj']
	// (//div[@class='cardLayout_matchData_Container__gJaPS']//button[contains(@class, 'button_btn__1XNg8')])[1]


	public WebElement CricketLink() {
		return  cricketnav;
	}

	
}