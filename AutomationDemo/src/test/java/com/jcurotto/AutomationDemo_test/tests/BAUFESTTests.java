package com.jcurotto.AutomationDemo_test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jcurotto.AutomationDemo_test.general.FUtils;
import com.jcurotto.AutomationDemo_test.general.BaseTest;
import com.jcurotto.AutomationDemo_test.pages.*;

import dataProvider.dataProviderClass;

public class BAUFESTTests extends BaseTest {

	@Test(testName = "Create new DemoBlaze user / Login / Add laptop to card")
	public void demoBlaze() {

		FUtils.log("Navigate to DemoBlaze");
		DEMOBLAZELandingPage dblp = super.goToDEMOBLAZELandingPage();
		FUtils.log("Click on Sign Up button");
		dblp.clickOnSignUpButton();
		FUtils.log("Type new Username");
		dblp.typeNewUsername("BAUFEST16");
		FUtils.log("Type new Password");
		dblp.typeNewPassword("1");
		FUtils.log("Click on Sign Up button from pop up");
		dblp.clickOnSignUpButtonPopUp();
		FUtils.log("Verify Alert message");
		Assert.assertTrue(dblp.verifyAlertMessage());
		FUtils.log("Click on Log In button");
		dblp.clickLoginButton();
		FUtils.log("Type username");
		dblp.typeUserName("BAUFEST16");
		FUtils.log("Type password");
		dblp.typeUserPassword("1");
		FUtils.log("Click on login button");
		DEMOBLAZEHomePage dbhp = dblp.clickButtonLoginPopUp();
		FUtils.log("Verify if user is logged in");
		Assert.assertTrue(dbhp.verifyIfUserIsLoggedIn("BAUFEST16"));
		FUtils.log("Click on Laptops button");
		DEMOBLAZELaptopsPage dblap = dbhp.clickButtonLaptops();
		FUtils.log("Click on a Laptop from the grid");
		DEMOBLAZELaptopDetailPage dbldp = dblap.clickOnALaptopName();
		FUtils.log("Click on Add to card button");
		dbldp.clickButtonAddToCart();
		FUtils.log("Verify alert message");
		Assert.assertTrue(dbldp.verifyAlertMessage());

	}


}
