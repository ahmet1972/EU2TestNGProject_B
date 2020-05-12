package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

//While the page is being loaded WebDriver couldn't interact with html page in which the specified webElement
// loated. WebDriver can inspect and locate the webElement but interaction is prevented.
// Basically it's hidden behind the loading bar. So, we need to delay the localisation attempt of WebDriver.
// That's why we ad below statement before the locating statement.

        Thread.sleep(5000); // This is static wait and comes from Java. It's possible that the test
                                 // fails or unnecessarily delays the execution of code.

        driver.findElement(By.id("username")).sendKeys("MikeSmith");

    }




}