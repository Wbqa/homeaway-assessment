package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import com.demoqa.base.AbstractBasePage;
/**
 * Page class maps to iPhone page and provides methods to add iPhone to cart and enable
 * checkout
 * 
 * @author Pallavi Kummari
 * 
 */
public class IphonePage extends AbstractBasePage {

	public IphonePage(WebDriver driver){
		this.driver = driver;
	}
	public CheckoutPage AddToCart(){
		elementVisibiltyWait (getLocator("addtocart"));
		driver.findElement(getLocator("addtocart")).click();
		elementVisibiltyWait (getLocator("checkout"));
		driver.findElement(getLocator("checkout")).click();
 	   	CheckoutPage cp = new CheckoutPage(driver);
		return cp;
	}
	
}
