package com.wbl1.util1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//This is an example of Factory design Pattern

public class WebDriverUtil1 {
    public static WebDriver getDriver(String browserName){

        //Object reference type as interface type.
        WebDriver driver;
        switch(browserName){
            case"chrome":
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\resourcesNew1\\drivers1\\chromedriver.exe");
                driver = new ChromeDriver();//polymorphism concept.
                break;

            case"firefox":
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\resourcesNew1\\drivers1\\geckodriver.exe");
                driver= new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\resourcesNew1\\drivers1\\geckodriver.exe");
                driver= new FirefoxDriver();

            }
            return driver;
        }
    }

