package com.wbl1.base1;

import com.wbl1.pages1.SearchResultsPage1;
import com.wbl1.util1.WebDriverWaitUtil1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage1 {

    protected WebDriver driver;
    @FindBy(how= How.ID,using="global-search-input")
    WebElement searchBox;


    @FindBy(how = How.ID,using="global-search-submit")
    WebElement searchButton;

    //Inorder to check whether the driver is initialized properly we use a constructor
    //As WebDriver is created in someOther place.ie HomePageTest1.

    public BasePage1(WebDriver driver){

        this.driver = driver;   //Initialization of driver object
    }

    public SearchResultsPage1 search(String searchData){
        //driver.findElement(By.id("global-search-input")).sendKeys(searchData);//Instead of hardcoding
        //driver.findElement(By.id("global-search-submit")).click();//walmart
       searchBox.sendKeys(searchData);
       searchButton.click();
        //WebDriverWaitUtil1.implicitWait(driver,15, TimeUnit.SECONDS);
        return PageFactory.initElements(driver, SearchResultsPage1.class);
    }

}
