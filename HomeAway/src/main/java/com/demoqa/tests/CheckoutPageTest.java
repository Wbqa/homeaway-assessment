package com.demoqa.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.AbstractBaseTest;
import com.demoqa.pages.CheckoutPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.IphonePage;

/**
 * Test class provides methods to validate following scenarios: <br>
 * 1) Verify total price of iPhone <br>
 * 2) Verify Order removal from shopping cart
 * 
 * @author Pallavi Kummari
 * 
 */
public class CheckoutPageTest extends AbstractBaseTest
{

	// Verify the total price of Apple iPhone 4S 16GB SIM-Free – Black is
	// $282.00(includes the shipping price)
	@Test
	public void totalPriceCheckTest()
	{
		HomePage hp = new HomePage(driver);
		IphonePage ipptest = hp.productCategoryToIphones();
		CheckoutPage cptest = ipptest.AddToCart();
		boolean actual = cptest.continueOrder();
		Assert.assertTrue(actual == false);
		System.out.println("est");
	}

	// Verify removing all items from your cart produces an empty cart message.
	@Test
	public void removeOrderTest()
	{
		HomePage hp = new HomePage(driver);
		IphonePage ipptest = hp.productCategoryToIphones();
		CheckoutPage cptest = ipptest.AddToCart();
		boolean actual = cptest.removeOrder();
		Assert.assertTrue(actual == true);
	}

}
