package com.wbl1.util1;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtil {
    public static void takeScreenshot(String fileName, WebDriver driver){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//we will take screenshot using File interface and store it in file.
        try{
            //We are using fileHandler and it has a method called copy. and we will move the screen shot from file to folder which we created.
            FileHandler.copy(file,new File("C:\\Users\\suganya\\SecondFramework_Demo\\src\\main\\resources\\screenshots1"+fileName+System.currentTimeMillis()+".png"));
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
