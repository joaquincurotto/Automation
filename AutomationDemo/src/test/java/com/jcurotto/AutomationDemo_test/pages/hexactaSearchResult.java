package com.jcurotto.AutomationDemo_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class hexactaSearchResult extends hexactaLandingPage{
    public hexactaSearchResult(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//article//h3//a")
    List<WebElement> listTitles;

    public boolean verifyIfTitleExist(){
        boolean flag = false;
        for (int i=0; i< listTitles.size();i++){
            if(listTitles.get(i).getText().toLowerCase().contains("what not to do when working with an outsourced software team")){
                flag=true;
            }
        }
        return flag;
    }
}
