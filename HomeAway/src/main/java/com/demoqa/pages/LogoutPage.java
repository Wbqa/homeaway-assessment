package com.demoqa.pages;

import org.openqa.selenium.WebDriver;

import com.demoqa.base.AbstractBasePage;

/**
 * Page class maps to Logout page class and provides methods to log back into
 * online store
 * 
 * @author Pallavi Kummari
 * 
 */
public class LogoutPage extends AbstractBasePage
{

	public LogoutPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public HomePage backToOnlineStore()
	{
		elementVisibiltyWait(20, 2, getLocator("backtoonlinestore"));
		driver.findElement(getLocator("backtoonlinestore")).click();
		HomePage hp = new HomePage(driver);
		return hp;
	}

}
