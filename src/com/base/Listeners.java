package com.base;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener{
	Utility_Class ScreeShot = new Utility_Class();
	@Override
	public void onTestSuccess(ITestResult result) {
	    // not implemented
		Reporter.log("Test Case Pass  "+result.getName()+" ",true);
		//System.out.println("Test Case Pass"+result.getName());
		try {
			ScreeShot.GetScreenShots();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	@Override
	public void onTestFailure(ITestResult result) {
	    // not implemented
		Reporter.log("Test Case Fail  "+result.getName()+" ",true);
		try {
			ScreeShot.GetScreenShots();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	@Override
	public void onTestSkipped(ITestResult result) {
	    // not implemented
		Reporter.log("Test Case Skip  "+result.getName()+" ",true);
		try {
			ScreeShot.GetScreenShots();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
