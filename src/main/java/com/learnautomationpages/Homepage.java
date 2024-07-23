package com.learnautomationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {

	WebDriver Driver;

	public Homepage(WebDriver Driver) {
		// TODO Auto-generated constructor stub
		this.Driver = Driver;
	}

	private By manageoption = By.xpath("//span[normalize-space()='Manage']");
	private By menu = By.xpath("//img[@alt='menu']");
	private By Signout = By.xpath("//button[normlaze-space()='Sign out']");

	public boolean ismanageDisplayed() {
		boolean status = Driver.findElement(manageoption).isDisplayed();
		return status;
	}

	public void signoutfromApplication() {
		Driver.findElement(menu).click();
		Driver.findElement(Signout).click();
	}

}
