package test_package;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base_class;
import com.base.Utility_Class;
import com.pom.Login_Page;
import com.pom.Pin_Page;
@Listeners(com.base.Listeners.class)
public class Pin_Page_Test extends Base_class{
		Login_Page login;
		Pin_Page GetPIN;
		Utility_Class utility;
		SoftAssert SA;
	@BeforeClass
	public void Setup() {
		LaunchBrowser("Chrome");
		login = new Login_Page (driver);
		utility = new Utility_Class();
		GetPIN = new Pin_Page(driver);
		SA = new SoftAssert();
	}
	
	@Test(priority = 0)
	public void CompleteLogin() throws InterruptedException, EncryptedDocumentException, IOException {
		login.LoginProcess(utility.GetDataFromExcel("Sheet2", 1, 0), utility.GetDataFromExcel("Sheet2", 1, 1));
		login.ClickButton();
	}
//	@Test(priority = 1)
//	public void PinPageIdValidation() throws EncryptedDocumentException, IOException, InterruptedException {
//		GetPIN.CLickOnContinueValidation();
//		String Expected = utility.GetDataFromExcel("Sheet3", 0,5);
//		String Actual = GetPIN.GetPinErrMsg();
//		SA.assertEquals(Actual, Expected);
//		SA.assertAll();
//		Thread.sleep(2000);
//	}
	@Test(priority = 1)
	public void ForGetTextValidation() throws EncryptedDocumentException, IOException, InterruptedException {
		String Expected = utility.GetDataFromExcel("Sheet3", 1, 0);
		String Actual = GetPIN.GetForget2FAValidation();
		SA.assertEquals(Actual, Expected);
		SA.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void EnterPinText() throws EncryptedDocumentException, IOException, InterruptedException {
		
		GetPIN.EnterUserId(utility.GetDataFromExcel("Sheet2", 1,2));
		GetPIN.CLickOnContinueValidation();
		
		
	}
	@AfterClass
	public void CLose() {
		driver.quit();
	}
	
	
}
