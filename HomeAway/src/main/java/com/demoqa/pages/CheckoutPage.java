package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.demoqa.base.AbstractBasePage;

/**
 * Page class maps to Checkout page and provides methods to place and remove
 * order
 * 
 * @author Pallavi Kummari
 * 
 */
public class CheckoutPage extends AbstractBasePage
{

	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public boolean continueOrder()
	{

		elementVisibiltyWait(getLocator("continueshopping"));
		driver.findElement(getLocator("continueshopping")).click();
		Select countrydd = new Select(driver.findElement(By.xpath("//*[@id='current_country']")));
		countrydd.selectByVisibleText("Canada");
		elementVisibiltyWait(getLocator("calculate"));
		driver.findElement(getLocator("calculate")).click();
		elementVisibiltyWait(getLocator("totalprice"));
		boolean found = driver.findElement(getLocator("totalprice")).isDisplayed();
		return found;
	}

	public boolean removeOrder()
	{
		elementVisibiltyWait(getLocator("remove"));
		driver.findElement(getLocator("remove")).click();
		elementVisibiltyWait(getLocator("removedorder"));
		String x = driver.findElement(getLocator("removedorder")).getText();
		if (x.contains("Oops, there is nothing"))
		;
		return true;
	}
}
