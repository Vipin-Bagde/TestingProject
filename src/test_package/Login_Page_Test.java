package test_package;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base_class;
import com.base.Utility_Class;
import com.pom.Login_Page;

@Listeners(com.base.Listeners.class)
public class Login_Page_Test extends Base_class{
	Login_Page login;
	Utility_Class utility;
	SoftAssert SA ;

	@BeforeClass
	public void setup () {
		LaunchBrowser("Chrome");
		login = new Login_Page(driver);
		utility = new Utility_Class();	
		SA = new SoftAssert();
	}
	@BeforeMethod
	public void refresh () throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	@Test (priority = -1)
	public void EnterUserValidation() throws EncryptedDocumentException, IOException,InvalidFormatException, InterruptedException {
		login.EnterUserId(utility.GetDataFromExcel("Sheet2", 1, 0));
		login.ClickButton();
		String ExpectediD= utility.GetDataFromExcel("Sheet3", 0, 0);
		String ActualiD = login.GetPasswordError();
		SA.assertEquals(ActualiD, ExpectediD);  
		SA.assertAll();
	}
	@Test(priority = 0)
	public void EnterPasswordValidation() throws EncryptedDocumentException, IOException, InterruptedException {
		login.EnterPassword(utility.GetDataFromExcel("Sheet2", 1, 1));
		login.ClickButton();
		String ExpectediD= utility.GetDataFromExcel("Sheet3", 0, 1);
		String ActualiD = login.GetUserIdError();
		SA.assertEquals(ActualiD, ExpectediD);  
		SA.assertAll();
	}
	@Test (priority = 1)
	public void ClickLoginVAlidation() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//login.GetForgotPasswordtext(utility.GetDataFromExcel("Sheet3", 0, 2));
		login.ClickButton();
		String Expected = utility.GetDataFromExcel("Sheet3", 0, 2);
		String Actual = login.GetForgotPasswordtext();
		SA.assertEquals(Actual, Expected);
		SA.assertAll();
		Thread.sleep(10000);
	}
	@AfterClass
	public void terminate() {
		driver.quit();
	}

}
