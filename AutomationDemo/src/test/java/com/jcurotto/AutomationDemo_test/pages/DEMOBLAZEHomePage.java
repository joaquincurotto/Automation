package com.jcurotto.AutomationDemo_test.pages;

import com.jcurotto.AutomationDemo_test.general.FUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DEMOBLAZEHomePage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public DEMOBLAZEHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
    }

    //LOCATORS
    @FindBy(id = "nameofuser")
    private WebElement buttonUsername;

    @FindBy(xpath = "//a[contains(text(),'Laptops')]")
    private WebElement buttonLaptops;

    public boolean verifyIfUserIsLoggedIn(String pUsername){
        FUtils.waitForElement(this.buttonUsername,"VISIBLE");
        if(this.buttonUsername.getText().equals("Welcome " +pUsername)){
            return true;
        }
        return false;
    }

    public DEMOBLAZELaptopsPage clickButtonLaptops(){
        FUtils.waitForElement(this.buttonLaptops,"CLICKABLE");
        this.buttonLaptops.click();
        return PageFactory.initElements(this.webDriver,DEMOBLAZELaptopsPage.class);
    }
}
