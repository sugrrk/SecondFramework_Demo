package com.wbl1.pages1;

import com.wbl1.base1.BasePage1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage1 extends BasePage1 {
    public SearchResultsPage1(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,SearchResultsPage1.class);//we are writing it here to use it anywhere we want.
    }
    public String getTitle(){

        return driver.getTitle();
    }
}
