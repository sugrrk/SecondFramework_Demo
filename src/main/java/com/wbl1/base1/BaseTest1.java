package com.wbl1.base1;


//Creation of driver object and closing of driver object is common and written before and after method.


import com.wbl1.util1.ConfigUtil1;
import com.wbl1.util1.Constants1;
import com.wbl1.util1.ScreenShotUtil;
import com.wbl1.util1.WebDriverUtil1;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest1 {
    protected WebDriver driver;
    protected static String url;
    protected static String browser;

    @BeforeSuite
    public void beforeSuite(){
        ConfigUtil1 configUtil1 = new ConfigUtil1(Constants1.RESOURCES_PATH + "/config.properties");
        url = configUtil1.getProperty("stageUrl");
        browser = configUtil1.getProperty("browser");
    }

    @BeforeMethod
    public void setUp(){  //Here we will use getDriver method to call the driver.
        driver = WebDriverUtil1.getDriver(browser);
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();



    }

    @AfterMethod
    public void teardown(ITestResult rs){ //This ITest result will have the screen shots .
        if(ITestResult.FAILURE==rs.getStatus()){
            ScreenShotUtil.takeScreenshot(rs.getName(),driver);//This method takes two parameters.
        }

        driver.quit();
    }
}
