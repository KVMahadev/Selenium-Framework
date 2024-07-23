package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learnautomation.Baseclass;
import com.learnautomation.config.ExcelReader;
import com.learnautomationpages.Homepage;
import com.learnautomationpages.Loginpage;

public class LoginTest extends Baseclass {

	
	@Test (dataProvider = "TEST DATA")
	public void login() {

		Loginpage login = new Loginpage(Driver);
		login.loginOption();
		Homepage home = login.logintoApplication("Admin@test.com", "Admin123");
		boolean status = home.ismanageDisplayed();
		Assert.assertTrue(status);
		home.signoutfromApplication();
		boolean signinstatus = login.isSignondisplayed();
		Assert.assertTrue(signinstatus);
		

	}
		@DataProvider(name="TEST DATA")
		public Object[][] getData() throws IOException{
			Object[][] data=ExcelReader.getExcelData("Login");
			return data;
		}
}
