package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.demoqa.base.AbstractBasePage;

/**
 * Page class maps to Home page and provides methods to navigate to Iphone and
 * Your Account pages
 * 
 * @author Pallavi Kummari
 * 
 */
public class HomePage extends AbstractBasePage
{

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public IphonePage productCategoryToIphones()
	{
		Actions products = new Actions(driver);
		elementVisibiltyWait(getLocator("productcategory"));
		products.moveToElement(driver.findElement(getLocator("productcategory"))).perform();
		elementVisibiltyWait(getLocator("iPhones"));
		driver.findElement(getLocator("iPhones")).click();
		IphonePage ipp = new IphonePage(driver);
		return ipp;
	}
	public IpadPage productCategoryToIpads()
	{
		Actions products = new Actions(driver);
		elementVisibiltyWait(getLocator("productcategory"));
		products.moveToElement(driver.findElement(getLocator("productcategory"))).perform();
		elementVisibiltyWait(getLocator("iPads"));
		driver.findElement(getLocator("iPads")).click();
		IpadPage ipd = new IpadPage(driver);
		return ipd;
		
	}

	public LoginPage homeToMyAccount()
	{
		elementVisibiltyWait(getLocator("myaccounticon"));
		driver.findElement(getLocator("myaccounticon")).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}

}
