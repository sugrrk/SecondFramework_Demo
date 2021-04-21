package com.wbl1.pages1;

//For every page class we create we need driver object .
// And for every page class we create we need corresponding test class.

import com.wbl1.base1.BasePage1;
import com.wbl1.util1.ExcelHelper1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage1 extends BasePage1 {//as soon as we use extend BasePage ,it asks us to create a matching constructor.

    private static Logger log = LogManager.getLogger(ExcelHelper1.class);//to use logs in this page we created log4j object

    @FindBy(how= How.CSS,using=".ClickThroughImage")
    List<WebElement> images;     //here we are using page factory instead of hardcoding the locators.
    public HomePage1(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver,this);

    }

    public int heroImages(){
       log.info("testing for hero images");
        //hard coding the locators
        //return driver.findElements(By.cssSelector((".ClickThroughImage"))).size();//we are going to return this.
        return images.size();//getting the number of images.
    }
}
