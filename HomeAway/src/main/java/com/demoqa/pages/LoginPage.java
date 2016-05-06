package com.demoqa.pages;

import org.openqa.selenium.WebDriver;

import com.demoqa.base.AbstractBasePage;

/**
 * Page class maps to Login page class and provides methods to log into online
 * store
 * 
 * @author Pallavi Kummari
 * 
 */
public class LoginPage extends AbstractBasePage
{

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public YourAccountPage loginToMyAccount()
	{
		elementVisibiltyWait(20, 2, getLocator("username"));
		driver.findElement(getLocator("username")).sendKeys("pallavi");
		elementVisibiltyWait(20, 2, getLocator("password"));
		driver.findElement(getLocator("password")).sendKeys("trishala");
		elementVisibiltyWait(20, 2, getLocator("login"));
		driver.findElement(getLocator("login")).submit();
		YourAccountPage yap = new YourAccountPage(driver);
		return yap;
	}

}
