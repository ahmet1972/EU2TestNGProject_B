package com.cybertek.tests.ahmetsHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day10_Homework_7 {

    WebDriver driver;

    @BeforeMethod
    public void before(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");

    }
    @AfterMethod
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);
        WebElement file_upload = driver.findElement(By.linkText("File Upload"));
        file_upload.click();
        Thread.sleep(2000);
        WebElement choseElement = driver.findElement(By.id("file-upload"));
        choseElement.sendKeys("/Users/nihat/Desktop/a.txt");

        Thread.sleep(2000);

        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);
        String expectedSubject= "File Uploaded!";
        String actualSubject = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualSubject,expectedSubject);

        String expectedName="a.txt";
        String actualName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualName,expectedName);

    }
}
