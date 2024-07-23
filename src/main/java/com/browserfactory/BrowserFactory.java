package com.browserfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;

import com.learnautomation.config.Configpage;

public class BrowserFactory {

	public static WebDriver getBrowser(String browsername, String appURL) {

		WebDriver Driver = null;

		if (browsername.equalsIgnoreCase("Chrome")) {
			Driver = new ChromeDriver();
		}

		else if (browsername.equalsIgnoreCase("Edge")) {
			Driver = new EdgeDriver();
		}

		else {
			Reporter.log("Log info - We could not open Edge and Chrome Browser");
		}
		Driver.manage().window().maximize();
		Driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(Configpage.getproperty("pageLoadTimeout"))));
		Driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(Configpage.getproperty("scripttimeout"))));		
		Driver.get(appURL);
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Configpage.getproperty("implicitwait"))));
		return Driver;
	}

	public static void closeBrowser(WebDriver Driver) {
		Driver.quit();
	}

}
