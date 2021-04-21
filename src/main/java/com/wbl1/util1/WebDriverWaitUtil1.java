package com.wbl1.util1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverWaitUtil1 {
    private static Logger log = LogManager.getLogger(WebDriverWaitUtil1.class);//loggers object


    //Explicit wait           here the name can be anything. i used waitForElementVisible
    public static WebElement waitForElementVisible(WebDriver driver, long timeInSecs, WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
            element = wait.until(ExpectedConditions.visibilityOf(element));

        }catch(Exception e){
            log.error("Exception occured while waiting for the specific element explicitly");
            log.error(e.getMessage());
        }
        return element;
    }


    //implicit wait.

    //Here we will take driver and it will take time in secs and unit. and we ll pass two parameters.
    public static void implicitWait(WebDriver driver, long timeInSecs, TimeUnit unit){
        driver.manage().timeouts().implicitlyWait(timeInSecs,unit);
    }
}
