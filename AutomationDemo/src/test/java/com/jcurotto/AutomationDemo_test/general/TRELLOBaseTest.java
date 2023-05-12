package com.jcurotto.AutomationDemo_test.general;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.jcurotto.AutomationDemo_test.pages.*;



public class TRELLOBaseTest {

	protected String methodName;
	protected String testScriptName;
	protected String testScriptID;
	protected SoftAssert softAssert;

	@BeforeSuite(alwaysRun = true)
	protected void beforeSuite() {
		new CONSTANTS();
	}

	@BeforeMethod(alwaysRun = true)
	protected void before(Method method, ITestResult testResult) {
		this.softAssert = new SoftAssert();

		this.getTestNames(method);
		FUtils.log("Starting execution for: " + this.methodName);

	}

	@AfterMethod(alwaysRun = true)
	protected void after(ITestResult testResult) throws IOException {
		String testExecutionResult = "";

		switch (testResult.getStatus()) {
		case ITestResult.FAILURE:
			testExecutionResult = "FAILED";
			break;

		case ITestResult.SUCCESS:
			testExecutionResult = "PASSED";
			break;

		case ITestResult.SKIP:
			testExecutionResult = "SKIPPED";
			break;

		default:
			break;
		}

		FUtils.log("The execution result is: " + testExecutionResult);
		FUtils.log("Finishing execution for: " + this.methodName);
		TRELLOWebDriver.getWDInstance().quitOWDInstance();
	}

	private void getTestNames(Method method) {
		this.methodName = method.getName();

		Annotation[] testAnnotations = method.getAnnotations();

		try {
			this.testScriptName = testAnnotations[0].toString();
			int p = this.testScriptName.indexOf("testName=");
			this.testScriptName = this.testScriptName.substring(p + 9, testScriptName.length() - 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected TRELLOLandingPage goToTRELLOLandingPage() {
		TRELLOWebDriver.getWDInstance().navigateTo(CONSTANTS.ENVIRONMENT_URL);
		return PageFactory.initElements(TRELLOWebDriver.getWDInstance().getDriver(), TRELLOLandingPage.class);
	}

	protected hexactaLandingPage goToHEXACTALandingPage() {
		TRELLOWebDriver.getWDInstance().navigateTo(CONSTANTS.ENVIRONMENT_HEXACTA_URL);
		return PageFactory.initElements(TRELLOWebDriver.getWDInstance().getDriver(), hexactaLandingPage.class);
	}


}
