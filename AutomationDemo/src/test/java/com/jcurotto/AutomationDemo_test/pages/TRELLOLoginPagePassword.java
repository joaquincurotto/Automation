package com.jcurotto.AutomationDemo_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jcurotto.AutomationDemo_test.general.FUtils;

public class TRELLOLoginPagePassword extends TRELLOLoginPageUsername{

	public TRELLOLoginPagePassword(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	//LOCATORS
	@FindBy(xpath = "//input[@id='password']")
	private WebElement inputPassword;
	
	@FindBy(id = "login-submit")
	private WebElement buttonLogin;
	
	
	//METHODS
	public TRELLOHomePage typePasswordAndClickOnLogin(String pPassword) {
		FUtils.waitForElement(this.inputPassword, "VISIBLE");
		this.inputPassword.sendKeys(pPassword);
		this.buttonLogin.click();
		return PageFactory.initElements(this.webDriver, TRELLOHomePage.class);
	}
}
