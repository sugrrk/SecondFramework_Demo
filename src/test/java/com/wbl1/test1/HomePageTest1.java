package com.wbl1.test1;


import com.wbl1.base1.BaseTest1;
import com.wbl1.pages1.HomePage1;
import com.wbl1.pages1.SearchResultsPage1;
import com.wbl1.util1.ExcelHelper1;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest1 extends BaseTest1 {  //dependency injecting

    HomePage1 hm; // creating a object for homepage.

    @DataProvider(name = "searchData")
    public Object[][] testData() {  //we are returning two dimensional array with input and output.
        //return new String[][]{{"bike", "bike - Walmart.com"}, {"helmet", "helmet - Walmart.com"}};//instead of hard coding data
        //we call Excel Helper here.
        return ExcelHelper1.getExcelData1("HomePage1-Data.xlsx","sheet1");
    }


    @Test(dataProvider = "searchData")
    //here we are automating the title page
    public void searchTest(String searchKeyword, String expected) {// Excel helper has two parameters
        //hm = PageFactory.initElements(driver,HomePage1.class);// we have initialize when we use pageFactory pattern
        hm = new HomePage1(driver);
        //instead of hardcoding bike,we can use search keyword here.
        SearchResultsPage1 sp = hm.search(searchKeyword);
        Assert.assertEquals(sp.getTitle(), expected);
    }

    @Test
    //here we are automating the multiple slider images in homepage.
     public void HeroImages() throws InterruptedException {
        hm = new HomePage1(driver);
        Thread.sleep(2000);
        Assert.assertEquals(hm.heroImages(),4);

        }





    }


