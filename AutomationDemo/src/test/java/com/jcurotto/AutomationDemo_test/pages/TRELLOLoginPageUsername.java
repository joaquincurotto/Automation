package com.jcurotto.AutomationDemo_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jcurotto.AutomationDemo_test.general.FUtils;

public class TRELLOLoginPageUsername extends TRELLOLandingPage {

	public TRELLOLoginPageUsername(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='user']")
	private WebElement inputUsername;
	
	@FindBy(xpath = "//input[@id='login' and @value='Iniciar sesión con Atlassian']")
	private WebElement buttonIniciarSesionConAtlassian;
	

	

	public TRELLOLoginPagePassword typeUsername(String pUsername) {
		FUtils.waitForElement(this.inputUsername, "VISIBLE");
		this.inputUsername.sendKeys(pUsername);
		FUtils.waitForElement(this.buttonIniciarSesionConAtlassian, "VISIBLE");
		this.buttonIniciarSesionConAtlassian.click();
		return PageFactory.initElements(this.webDriver, TRELLOLoginPagePassword.class);
	}
	


}
