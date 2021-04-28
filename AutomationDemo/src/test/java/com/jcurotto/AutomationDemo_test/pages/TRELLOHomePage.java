package com.jcurotto.AutomationDemo_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jcurotto.AutomationDemo_test.general.FUtils;

public class TRELLOHomePage extends TRELLOLandingPage {

	@FindBy(xpath = "//div[@class='board-tile mod-add']")
	private WebElement buttonTableros;

	@FindBy(xpath = "//button[contains(text(),'Crear un tablero nuevo...')]")
	private WebElement buttonCrearNuevoTablero;

	public TRELLOHomePage(WebDriver webDriver) {
		super(webDriver);
	}

	public TRELLOCrearTableroPage clickOnButtonTableros() {
		FUtils.waitForElement(this.buttonTableros, "CLICKABLE");
		this.buttonTableros.click();
		return PageFactory.initElements(this.webDriver, TRELLOCrearTableroPage.class);
	}
}
