package com.jcurotto.AutomationDemo_test.general;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public abstract class FUtils {

	/*
	 * ======================================================================
	 * =========================== METHODS ==================================
	 * ======================================================================
	 */
	public static void log(String pMessage) {
			Reporter.log(pMessage, true);
	}


	public static void waitForElement(WebElement webElement, String waitFor) {
		WebDriverWait webDriverWait = new WebDriverWait(TRELLOWebDriver.getWDInstance().getDriver(),
				CONSTANTS.WEBELEMENT_DEFAULT_TIMEOUT);

		switch (waitFor.toUpperCase()) {
		case "CLICKABLE":
			webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
			break;
		case "SELECTED":
			webDriverWait.until(ExpectedConditions.elementToBeSelected(webElement));
			break;
		case "VISIBLE":
			webElement = webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
			break;

		case "SLEEP":
			try {
				Thread.sleep(CONSTANTS.WEBELEMENT_DEFAULT_TIMEOUT * 150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
	}

}
