package com.jcurotto.AutomationDemo_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jcurotto.AutomationDemo_test.general.FUtils;
import com.jcurotto.AutomationDemo_test.general.TRELLOWebDriver;

public class TRELLOTableropage extends TRELLOCrearTableroPage {

	public TRELLOTableropage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	// LOCATORS
	@FindBy(xpath = "//div[@id='board']")
	private WebElement board;

	// METHODS

	public boolean verificarSielTableroSeCreo(String pNombreTablero) {
		FUtils.waitForElement(this.board, "VISIBLE");
		String URL = TRELLOWebDriver.getDriver().getCurrentUrl();
		System.out.println(URL);
		if (URL.contains(pNombreTablero.toLowerCase())) {
			return true;
		}
		return false;
	}

}
