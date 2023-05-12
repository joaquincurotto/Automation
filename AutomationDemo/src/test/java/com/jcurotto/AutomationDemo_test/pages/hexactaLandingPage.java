package com.jcurotto.AutomationDemo_test.pages;

import com.jcurotto.AutomationDemo_test.general.FUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hexactaLandingPage {
    protected WebDriver driver;

    public hexactaLandingPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath ="//span[contains(text(),'Search')]")
    private WebElement buttonSearch;

    @FindBy(id = "search-field")
    private WebElement inputSearch;

    public void clickButtonSearch(){
        FUtils.waitForElement(this.buttonSearch, "VISIBLE");
        this.buttonSearch.click();
    }

    public hexactaSearchResult typeSearch(){
        FUtils.waitForElement(this.inputSearch, "VISIBLE");
        this.inputSearch.sendKeys("Outsource");
        inputSearch.sendKeys(Keys.ENTER);
        return PageFactory.initElements(this.driver,hexactaSearchResult.class);
    }

}
