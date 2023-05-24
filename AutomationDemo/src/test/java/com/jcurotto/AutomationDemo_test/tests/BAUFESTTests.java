package com.jcurotto.AutomationDemo_test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jcurotto.AutomationDemo_test.general.FUtils;
import com.jcurotto.AutomationDemo_test.general.BaseTest;
import com.jcurotto.AutomationDemo_test.pages.*;

import dataProvider.dataProviderClass;

public class BAUFESTTests extends BaseTest {

	@Test(testName = "Create new DemoBlaze user / Login / Add laptop to card", dataProvider="DataProvider", dataProviderClass = dataProviderClass.class)
	public void demoBlaze(String pUsername, String pPassword) {

		//Test Methods
		FUtils.log("Navigate to DemoBlaze");
		DEMOBLAZELandingPage dblp = super.goToDEMOBLAZELandingPage();
		FUtils.log("Click on Sign Up button");
		dblp.clickOnSignUpButton();
		FUtils.log("Type new Username");
		dblp.typeNewUsername(pUsername);
		FUtils.log("Type new Password");
		dblp.typeNewPassword(pPassword);
		FUtils.log("Click on Sign Up button from pop up");
		dblp.clickOnSignUpButtonPopUp();
		FUtils.log("Verify Alert message");
		Assert.assertTrue(dblp.verifyAlertMessage());
		FUtils.log("Click on Log In button");
		dblp.clickLoginButton();
		FUtils.log("Type username");
		dblp.typeUserName(pUsername);
		FUtils.log("Type password");
		dblp.typeUserPassword(pPassword);
		FUtils.log("Click on login button");
		DEMOBLAZEHomePage dbhp = dblp.clickButtonLoginPopUp();
		FUtils.log("Verify if user is logged in");
		Assert.assertTrue(dbhp.verifyIfUserIsLoggedIn(pUsername));
		FUtils.log("Click on Laptops button");
		DEMOBLAZELaptopsPage dblap = dbhp.clickButtonLaptops();
		FUtils.log("Click on a Laptop from the grid");
		String laptopName= dblap.laptopName();
		DEMOBLAZELaptopDetailPage dbldp = dblap.clickOnALaptopName();
		FUtils.log("Click on Add to card button");
		dbldp.clickButtonAddToCart();
		FUtils.log("Verify alert message");
		Assert.assertTrue(dbldp.verifyAlertMessage());
		FUtils.log("Click on Cart button");
		DEMOBLAZECartPage dbcp = dbldp.clickButtonCart();
		FUtils.log("Verify that the selected laptop was added to the cart");
		Assert.assertTrue(dbcp.verifyLaptopInCart(laptopName));

	}


}
