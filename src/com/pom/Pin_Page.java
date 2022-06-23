package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Pin_Page {
	
		public Pin_Page(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		@FindBy (xpath = "//div[@class='form-header text-center']/h2") private WebElement GetUserIdPin;
		@FindBy(id = "pin") private WebElement enterPin;
		@FindBy(xpath = "//button[@type='submit']") private WebElement clickOnContinue;
		@FindBy(xpath = "//a[text()='Forgot 2FA?']") private WebElement Forget2FA;
		@FindBy(xpath = "//span[text()='This field is required']") private WebElement pinErrMsg;
		
		public String GetUserIdValidation () {
			return GetUserIdPin.getText();
		}	
		public void EnterUserId (String pin) throws InterruptedException {
			 enterPin.sendKeys(pin); 
			 Thread.sleep(2000);
		}
		public void CLickOnContinueValidation () throws InterruptedException {
			
			clickOnContinue.click();
		}
		public String GetForget2FAValidation () {
			return Forget2FA.getText();
		}
		public String GetPinErrMsg() {
			return pinErrMsg.getText();
		}
		
}
