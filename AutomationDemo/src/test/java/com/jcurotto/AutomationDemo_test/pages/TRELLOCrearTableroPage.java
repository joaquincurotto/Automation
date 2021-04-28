package com.jcurotto.AutomationDemo_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jcurotto.AutomationDemo_test.general.FUtils;

public class TRELLOCrearTableroPage extends TRELLOHomePage {

	public TRELLOCrearTableroPage(WebDriver webDriver) {
		super(webDriver);
	}

	// LOCATORS
	@FindBy(xpath = "//input[@placeholder='Añadir título de tablero']")
	private WebElement inputNombreTablero;

	@FindBy(xpath = "//button[text() ='Crear tablero']")
	private WebElement buttonCrearTablero;

	// METHODS

	public void nombreTablero(String pNombreTablero) {
		FUtils.waitForElement(this.inputNombreTablero, "VISIBLE");
		this.inputNombreTablero.sendKeys(pNombreTablero);
	}

	public TRELLOTableropage clickButtonCrearTablero() {
		FUtils.waitForElement(this.buttonCrearTablero, "CLICKABLE");
		this.buttonCrearTablero.click();
		return PageFactory.initElements(this.webDriver, TRELLOTableropage.class);
	}

}
