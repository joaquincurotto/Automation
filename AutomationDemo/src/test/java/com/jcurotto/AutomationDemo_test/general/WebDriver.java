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
		// Ensure that the driver is created if it's null
		if (webDriver == null) {
			getWDInstance();
		}
		return webDriver;
	}

	private void createDriver() {
		try {
			switch (CONSTANTS.BROWSER) {
				case "CHROME":
					WebDriverManager.chromedriver().clearDriverCache().setup();  // Force refresh
					WebDriverManager.chromedriver().setup();
					webDriver = new ChromeDriver(this.setChromeOptions());
					break;

				default:
					throw new IllegalArgumentException("The specified browser is not correct.");
			}
		} catch (Exception e) {
			System.err.println("Error occurred while creating the WebDriver: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Failed to initialize WebDriver", e);
		}
	}

	private void setWebDriverParameters() {
		if (webDriver != null) {
			webDriver.manage().deleteAllCookies();
			webDriver.manage().timeouts().setScriptTimeout(CONSTANTS.WEBDRIVER_DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		} else {
			throw new IllegalStateException("WebDriver is not initialized.");
		}
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
			INSTANCE = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
