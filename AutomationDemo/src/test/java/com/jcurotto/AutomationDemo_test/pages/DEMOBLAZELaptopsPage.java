package com.jcurotto.AutomationDemo_test.pages;

import com.jcurotto.AutomationDemo_test.general.FUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DEMOBLAZELaptopsPage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public DEMOBLAZELaptopsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
    }

    //LOCATORS
    @FindBy(xpath = "//h4[@class='card-title']")
    private List<WebElement> listLaptops;

    public DEMOBLAZELaptopDetailPage clickOnALaptopName(){
        FUtils.waitForElement(this.listLaptops.get(1),"SLEEP");
        this.listLaptops.get(1).click();
        return PageFactory.initElements(this.webDriver,DEMOBLAZELaptopDetailPage.class);
    }
}
