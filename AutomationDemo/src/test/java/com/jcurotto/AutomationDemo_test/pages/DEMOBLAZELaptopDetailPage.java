package com.jcurotto.AutomationDemo_test.pages;

import com.jcurotto.AutomationDemo_test.general.FUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DEMOBLAZELaptopDetailPage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public DEMOBLAZELaptopDetailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
    }
    //LOCATORS
    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement buttonCart;


    public void clickButtonAddToCart(){
        FUtils.waitForElement(this.buttonAddToCart,"CLICKABLE");
        this.buttonAddToCart.click();
    }
    public boolean verifyAlertMessage(){
        boolean laptopAddedToCart=false;
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        if(alert.getText().equals("Product added.")) {
            alert.accept();
            return true;
        }
        return false;
    }

}
