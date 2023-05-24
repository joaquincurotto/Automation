package com.jcurotto.AutomationDemo_test.pages;

import com.jcurotto.AutomationDemo_test.general.FUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DEMOBLAZECartPage {
    protected WebDriver webDriver;

    public DEMOBLAZECartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //LOCATORS
    @FindBy(xpath="(//tr//td)[2]")
    private WebElement laptopNameInCart;

    public boolean verifyLaptopInCart(String pLaptopName){
        FUtils.waitForElement(this.laptopNameInCart,"SLEEP");
        if(this.laptopNameInCart.getText().equals(pLaptopName)){
            return true;
        }
        return false;
    }
}
