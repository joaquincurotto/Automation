package com.jcurotto.AutomationDemo_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jcurotto.AutomationDemo_test.general.FUtils;

public class TRELLOLandingPage {

	protected WebDriver webDriver;

	// ==LOCATORS==
	@FindBy(xpath = "//a[@class='btn btn-sm btn-link text-primary']")
	private WebElement buttonIniciarSesion;

	public TRELLOLoginPageUsername clickIniciarSesion() {
		FUtils.waitForElement(this.buttonIniciarSesion, "CLICKABLE");
		this.buttonIniciarSesion.click();
		return PageFactory.initElements(this.webDriver, TRELLOLoginPageUsername.class);

	}

	public TRELLOLandingPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

}
