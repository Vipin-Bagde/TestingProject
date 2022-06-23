package test_package;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base_class;
import com.base.Utility_Class;
import com.pom.Login_Page;
import com.pom.Pin_Page;

public class Home_Page_Test extends Base_class{
		Login_Page login;
		Utility_Class utility;
		Pin_Page GetPinPage;
		
	@BeforeClass
	public void Setup() {
		
		LaunchBrowser("Chrome");
		login = new Login_Page(driver);
		utility = new Utility_Class ();
		GetPinPage = new Pin_Page(driver);
	}
	@Test
	public void LoginProcess() throws EncryptedDocumentException, IOException, InterruptedException {
		
		login.LoginProcess(utility.GetDataFromExcel("Sheet2", 1, 0), utility.GetDataFromExcel("Sheet2", 1, 1));
		login.ClickButton();
		Thread.sleep(2000);
	}
	@Test
	public void PinPageProcess() throws EncryptedDocumentException, IOException, InterruptedException {
		
		GetPinPage.EnterUserId(utility.GetDataFromExcel("Sheet2", 1,2));
		Thread.sleep(2000);
		GetPinPage.CLickOnContinueValidation();
	}
//	@AfterClass
//	public void QuiteBrowser() {
//		
//		driver.quit();
//	}

}
