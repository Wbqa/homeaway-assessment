package com.demoqa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.demoqa.utils.StyleLocator;

/**
 * Abstract base class extended by all page classes providing utility methods
 * 
 * @author Pallavi Kummari
 * 
 */

public abstract class AbstractBasePage
{
	protected WebDriver driver = null;
	private static StyleLocator _locator = new StyleLocator(AbstractBasePage.class.getResource("/locator/locators.properties").getPath());

	public By getLocator(String key)
	{
		return _locator.get(key);
	}

	public FluentWait<WebDriver> elementVisibiltyWait(int timeout, int poll, By locator)
	{
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(poll, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		fWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return fWait;
	}

	public FluentWait<WebDriver> elementVisibiltyWait(By locator)
	{
		return elementVisibiltyWait(20, 2, locator);
	}

}
