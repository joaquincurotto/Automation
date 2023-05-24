package com.jcurotto.AutomationDemo_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;

import com.jcurotto.AutomationDemo_test.general.FUtils;

public class DEMOBLAZELandingPage {

	protected WebDriver webDriver;
	protected WebDriverWait wait;


	public DEMOBLAZELandingPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		wait = new WebDriverWait(webDriver, 10);
	}

	// ==LOCATORS==
	// ==HEADER==
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	private WebElement buttonLogIn;

	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	private WebElement buttonSignUp;

	// ==SIGNUP==
	@FindBy(id = "sign-username")
	private WebElement inputSignUpUsername;

	@FindBy(id = "sign-password")
	private WebElement inputSignUpPassword;

	@FindBy(xpath = "//button[contains(text(),'Sign up')]")
	private WebElement buttonSignUpPopUp;

	// ==LOGIN==

	@FindBy(id = "loginusername")
	private WebElement inputLoginUsername;

	@FindBy(id = "loginpassword")
	private WebElement inputLoginPassword;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	private WebElement buttonLoginPopUp;

	public void clickOnSignUpButton(){
		FUtils.waitForElement(this.buttonSignUp,"CLICKABLE");
		this.buttonSignUp.click();
	}

	public void typeNewUsername(String newUsername){
		FUtils.waitForElement(this.inputSignUpUsername,"VISIBLE");
		this.inputSignUpUsername.sendKeys(newUsername);
	}

	public void typeNewPassword(String newPassword){
		FUtils.waitForElement(this.inputSignUpPassword,"VISIBLE");
		this.inputSignUpPassword.sendKeys(newPassword);
	}

	public void clickOnSignUpButtonPopUp(){
		FUtils.waitForElement(this.buttonSignUpPopUp,"CLICKABLE");
		this.buttonSignUpPopUp.click();
	}

	public boolean verifyAlertMessage(){
		boolean userCreated=false;
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = webDriver.switchTo().alert();
		if(alert.getText().equals("Sign up successful.")) {
			alert.accept();
			return true;
		}
		return false;
	}

	public void clickLoginButton(){
		FUtils.waitForElement(this.buttonLogIn,"CLICKABLE");
		this.buttonLogIn.click();
	}

	public void typeUserName(String pUsername){
		FUtils.waitForElement(this.inputLoginUsername, "VISIBLE");
		this.inputLoginUsername.sendKeys(pUsername);
	}

	public void typeUserPassword(String pUserPassword){
		FUtils.waitForElement(this.inputLoginPassword, "VISIBLE");
		this.inputLoginPassword.sendKeys(pUserPassword);
	}

	public DEMOBLAZEHomePage clickButtonLoginPopUp(){
		FUtils.waitForElement(this.buttonLoginPopUp,"CLICKABLE");
		this.buttonLoginPopUp.click();
		return PageFactory.initElements(this.webDriver,DEMOBLAZEHomePage.class);
	}


}
