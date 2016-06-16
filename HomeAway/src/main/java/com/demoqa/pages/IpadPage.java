package com.demoqa.pages;

import org.openqa.selenium.WebDriver;

import com.demoqa.base.AbstractBasePage;

public class IpadPage extends AbstractBasePage {
	
	public IpadPage(WebDriver driver){
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
