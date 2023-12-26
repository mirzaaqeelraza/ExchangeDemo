/*
 * package com.ExchangeDemo.LoginPage;
 * 
 * public class MyAccountPage {
 * 
 * }
 */

package com.ExchangeDemo.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	 @FindBy(xpath = "//button[@class=\"page_log_btn__3tNNt page_profile__zP7Lk\"]")   ////button[@class="page_log_btn__3tNNt page_profile__zP7Lk"]
	 WebElement myAccountPage;

	 public WebElement myAccount() {
	 return myAccountPage;
	 }

	 
}