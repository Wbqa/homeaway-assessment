package com.demoqa.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.AbstractBaseTest;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.pages.LogoutPage;
import com.demoqa.pages.YourAccountPage;

/**
 * Test class provides methods to validate following scenarios: <br>
 * 1) Verify account profile update <br>
 * 2) Verify if a/c profile is saved after user is logged out and logged back
 * into online store
 * 
 * @author Pallavi Kummari
 * 
 */
public class YourAccountPageTest extends AbstractBaseTest
{

	// Verify updating your account details is saved
	@Test
	public void updateProfileTest()
	{
		HomePage hpTest = new HomePage(driver);
		LoginPage lipTest = hpTest.homeToMyAccount();
		YourAccountPage yapTest = lipTest.loginToMyAccount();
		yapTest.updateProfile();
		boolean actual = yapTest.retrieveProfile();
		Assert.assertTrue(actual == true);
	}

	// Verify your account details are retrieved after logging out and back in
	// using the My Account link.
	@Test
	public void retrieveProfileTest()
	{
		HomePage hpTest = new HomePage(driver);
		LoginPage lipTest = hpTest.homeToMyAccount();
		YourAccountPage yapTest = lipTest.loginToMyAccount();
		yapTest.updateProfile();
		LogoutPage lopTest = yapTest.logOut();
		HomePage hpTest1 = lopTest.backToOnlineStore();
		LoginPage lipTest1 = hpTest1.homeToMyAccount();
		YourAccountPage yapTest1 = lipTest1.loginToMyAccount();
		boolean actual = yapTest1.retrieveProfile();
		Assert.assertTrue(actual == true);
	}

}
