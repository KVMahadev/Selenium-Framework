package com.learnautomation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.browserfactory.BrowserFactory;
import com.learnautomation.config.Configpage;

public class Baseclass {

	public WebDriver Driver;

	@BeforeClass
	public void setup() {
		
		Reporter.log("Log info -Running Before class - Setting up Browser", true);
		Driver = BrowserFactory.getBrowser(Configpage.getproperty("browser"), Configpage.getproperty("appURL"));
		Reporter.log("Log info -Browser is opened", true);

	}

	@AfterClass
	public void teardown() {
		BrowserFactory.closeBrowser(Driver);
		Reporter.log("Log-info Browser is closed", true);

	}

}
