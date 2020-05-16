package com.cybertek.tests.ahmetsHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day10_Homework_9101112 {

    WebDriver driver;

    @BeforeMethod
    public void before(){
        driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Status Codes")).click();

    }
    @AfterMethod
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

//    @Test
//    public void test1(){
//
//
//        driver.findElement(By.linkText("200")).click();
//
//        String expectedMessage = "This page returned a 200 status code";
//        String actualMessage = driver.findElement(By.tagName("p")).getText();
//
//        System.out.println("actualMessage = " + actualMessage);
//        Assert.assertTrue(actualMessage.contains(expectedMessage), "Verify message 200 is displayed");
//
//        //System.out.println(driver.findElement(By.xpath("//p/text()")).toString());
//
//
//    }
//
//    @Test
//    public void test2(){
//
//
//
//        driver.findElement(By.linkText("301")).click();
//
//        String expectedMessage = "This page returned a 301 status code";
//        String actualMessage = driver.findElement(By.tagName("p")).getText();
//
//        System.out.println("actualMessage = " + actualMessage);
//        Assert.assertTrue(actualMessage.contains(expectedMessage), "Verify message 301 is displayed");
//        //String actualMessage = driver.findElement(By.xpath("//p/text()[1]"));
//
//    }
//
//    @Test
//    public void test3(){
//
//        driver.findElement(By.linkText("404")).click();

//
//        String expectedMessage = "This page returned a 404 status code";
//        String actualMessage = driver.findElement(By.tagName("p")).getText();
//
//        System.out.println("actualMessage = " + actualMessage);
//        Assert.assertTrue(actualMessage.contains(expectedMessage), "Verify message 404 is displayed");
//
//    }
//
//    @Test
//    public void test4(){
//
//        driver.findElement(By.linkText("500")).click();
//
//        String expectedMessage = "This page returned a 500 status code";
//        String actualMessage = driver.findElement(By.tagName("p")).getText();
//
//        System.out.println("actualMessage = " + actualMessage);
//        Assert.assertTrue(actualMessage.contains(expectedMessage), "Verify message 500 is displayed");
//
//    }

    //    @DataProvider(name="Createdata")
//    public Object[][] Createdata(){
//        Object[][] data = new Object[4][2];
//
//        data[0][0]= "This page returned a 200 status code";
//        data[0][1]= "200";
//        data[1][0]= "This page returned a 301 status code";
//        data[1][1]= "301";
//        data[2][0]= "This page returned a 404 status code";
//        data[2][1]= "404";
//        data[3][0]= "This page returned a 500 status code";
//        data[3][1]= "500";
//        return data;
//    }
    @DataProvider(name="Createdata")
    public Object[][] Createdata(){
        return new Object[] []{
                {"200","This page returned a 200 status code."},
                {"301","This page returned a 301 status code."},
                {"404","This page returned a 404 status code."},
                {"500","This page returned a 500 status code."},
        };
    }
    @Test(dataProvider="Createdata")
    public void test(String locator,String expected){

        driver.findElement(By.linkText(locator)).click();
        String actualMessage = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(actualMessage.contains(expected),"Verify "+expected+" is displayed");
    }



}
