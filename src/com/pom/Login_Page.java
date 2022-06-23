package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Login_Page {
	
	public Login_Page(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
	
	@FindBy(id = "userid") private WebElement UserIdTextBoxElement;
	@FindBy(id = "password") private WebElement PasswordTextBoxElement;
	@FindBy(tagName  = "button") private WebElement LoginButton;
	
	@FindBy(xpath = "//span[text()='User ID should be minimum 6 characters.']") 
	private WebElement usrIdErrMsgElement;
	
	@FindBy(xpath = "//span[text()='Password should be minimum 6 characters.']")
	private WebElement PasswordErrMsgElement;
	
	@FindBy(xpath = "//a[text()='Forgot user ID or password?']")
	private WebElement forgotPassElement;
	
	public void EnterUserId(String UserId) {
		UserIdTextBoxElement.sendKeys(UserId);
	}
	
	public void EnterPassword(String Password) {
		PasswordTextBoxElement.sendKeys(Password);
	}
	
	public void ClickButton() throws InterruptedException {
		LoginButton.click();
		Thread.sleep(2000);
	}
	public String GetUserIdError() {
		return usrIdErrMsgElement.getText();
		
	}
	public String GetPasswordError() {
		return PasswordErrMsgElement.getText();
	}
	
	public String GetForgotPasswordtext() {
		
		return forgotPassElement.getText();
	}
	
	public void LoginProcess(String UserId, String Password ) {
		UserIdTextBoxElement.sendKeys(UserId);
		PasswordTextBoxElement.sendKeys(Password);
		LoginButton.click();
	}
	
	
	
	
}

