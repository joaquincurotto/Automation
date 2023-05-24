package com.jcurotto.AutomationDemo_test.general;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriver {

	private static WebDriver INSTANCE = null;
	private static org.openqa.selenium.WebDriver webDriver = null;

	public static WebDriver getWDInstance() {
		if (INSTANCE == null) {
			INSTANCE = new WebDriver();
		}
		return INSTANCE;
	}

	private WebDriver() {

		this.createDriver();
	}

	public static org.openqa.selenium.WebDriver getDriver() {
		return webDriver;
	}

	private void createDriver() {
		try {
			switch (CONSTANTS.BROWSER) {

			case "CHROME":
				WebDriverManager.chromedriver().setup();
				webDriver = new ChromeDriver(this.setChromeOptions());
				break;

			default:
				FUtils.log("The specified browser is not correct.");
				break;
			}

		} catch (

		Exception e) {
			System.out.println(
					"An error has occurred when trying to instantiate the WebDriver for " + CONSTANTS.BROWSER);
			e.printStackTrace();
		}
	}

	private void setWebDriverParameters() {
//		webDriver.manage().window().fullscreen();
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().setScriptTimeout(CONSTANTS.WEBDRIVER_DEFAULT_TIMEOUT, TimeUnit.SECONDS);
	}

	private ChromeOptions setChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--incognito");

		return options;
	}

	public void navigateTo(String url) {
		setWebDriverParameters();
		getDriver().navigate().to(url);
	}

	public void quitOWDInstance() {

		try {

			if (webDriver != null) {
				FUtils.waitForElement(null, "SLEEP");
				webDriver.close();
				webDriver.quit();
			}

			if (INSTANCE != null) {
				INSTANCE = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
