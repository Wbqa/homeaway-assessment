package com.demoqa.utils;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;

/**
 * Helper class provide methods for CSS and XPath locators from properties file
 * 
 * @author Pallavi Kummari
 * 
 */
public class StyleLocator
{
	private HashMap<String, String> _locators;

	public StyleLocator(String filePath)
	{
		_locators = new HashMap<String, String>();

		initLocatorMap(filePath);
	}

	private void initLocatorMap(String filePath)
	{
		Properties prop = new Properties();
		try
			{
				prop.load(new FileReader(filePath));
			}
		catch (Exception e)
			{
				e.printStackTrace();
			}

		for (Object key : prop.keySet())
			_locators.put((String) key, prop.get(key).toString());

	}

	public By get(String Key)
	{
		String value = _locators.get(Key);
		String[] items = value.split(";");
		if (items[0].equalsIgnoreCase("xpath"))
			{
				return By.xpath(items[1]);
			}
		else return By.cssSelector(items[1]);
	}
}
