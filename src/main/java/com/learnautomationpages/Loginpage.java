package com.learnautomationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {

	WebDriver Driver;

	public Loginpage(WebDriver Driver) {
		this.Driver = Driver;
	}

	private By username = By.xpath("//input[@id='email1']");
	private By password = By.xpath("//input[@id='password1']");
	private By menuBy = By.xpath("//image[@alt='menu']");
	private By loginoption = By.xpath("//button[normalize-space()='Log in']");	
	private By loginButton = By.xpath("//button[normalize-space()='Sign in'']");
	private By loginsignInOption = By.xpath("//h2[normalize-space()='Sign in'']");
	private By Socialmediaoptions = By.xpath("//div[@class='social-btns']//a");

	public Homepage logintoApplication(String uname, String pass) {
		Driver.findElement(username).sendKeys(uname);
		Driver.findElement(password).sendKeys(pass);
		Driver.findElement(loginButton).click();
		Homepage Home = new Homepage(Driver);
		return Home;
	}
	
	public void loginOption() {
		Driver.findElement(menuBy).click();
		Driver.findElement(loginoption).click();
		
	}

	public int numberofsocialmediaicons() {
		return Driver.findElements(Socialmediaoptions).size();
	}

	public boolean isSignondisplayed() {
		return Driver.findElement(loginsignInOption).isDisplayed();
	}

}
