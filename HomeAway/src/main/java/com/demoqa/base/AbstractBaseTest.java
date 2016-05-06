package com.demoqa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Abstract base class extended by all TestNG Test classes providing utility
 * methods for Selenium WebDriver API
 * 
 * @author Pallavi Kummari
 * 
 */
public abstract class AbstractBaseTest
{

	protected WebDriver driver;

	@BeforeMethod
	public void openBrowser()
	{
		String browser = "ff";
		if (browser.equals("ff"))
			{
				driver = new FirefoxDriver();
			}
		else if (browser.equals("ie"))
			{
				driver = new InternetExplorerDriver();
			}
		else if (browser.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}

		driver.get("http://store.demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
