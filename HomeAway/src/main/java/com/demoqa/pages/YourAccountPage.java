package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.demoqa.base.AbstractBasePage;

/**
 * Page class maps to Your Account page and provides methods update/retrieve a
 * profile and logout from online store
 * 
 * @author Pallavi Kummari
 * 
 */
public class YourAccountPage extends AbstractBasePage
{

	public YourAccountPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void updateProfile()
	{

		elementVisibiltyWait(getLocator("myaccountdetails"));
		driver.findElement(getLocator("myaccountdetails")).click();
		elementVisibiltyWait(getLocator("firstname"));
		driver.findElement(getLocator("firstname")).clear();
		elementVisibiltyWait(getLocator("firstname"));
		driver.findElement(getLocator("firstname")).sendKeys("pallavi");
		Select countrydd = new Select(driver.findElement(getLocator("accountcountry")));
		countrydd.selectByVisibleText("USA");
		elementVisibiltyWait(getLocator("accountzip"));
		driver.findElement(getLocator("accountzip")).clear();
		elementVisibiltyWait(getLocator("accountzip"));
		driver.findElement(getLocator("accountzip")).sendKeys("78615");
		elementVisibiltyWait(getLocator("submit"));
		driver.findElement(getLocator("submit")).submit();
	}

	public LogoutPage logOut()
	{
		elementVisibiltyWait(getLocator("logout"));
		driver.findElement(getLocator("logout")).click();
		LogoutPage lop = new LogoutPage(driver);
		return lop;
	}

	public boolean retrieveProfile()
	{
		elementVisibiltyWait(getLocator("myaccountdetails"));
		driver.findElement(getLocator("myaccountdetails")).click();
		elementVisibiltyWait(getLocator("contentfirstname"));
		boolean a = driver.findElement(getLocator("contentfirstname")).isDisplayed();
		elementVisibiltyWait(getLocator("contentcountry"));
		boolean b = driver.findElement(getLocator("contentcountry")).isSelected();
		elementVisibiltyWait(getLocator("contentzip"));
		boolean c = driver.findElement(getLocator("contentzip")).isDisplayed();
		if (a && b && c == true) return true;
		return false;
	}

}
