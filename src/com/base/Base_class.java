package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_class {

	public static WebDriver driver;

	public static void LaunchBrowser(String  BrowserNames ) {
		switch (BrowserNames) {
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "E:\\Selenium Tools\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
			break;
		default: System.out.println("No Browser with the given name ");
			break;
		}
		driver.get("https://kite.zerodha.com/");
	}
}
