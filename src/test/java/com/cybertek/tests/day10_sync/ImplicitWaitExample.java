package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//You can type this anywhere after above line
// As it's the case here, sometimes while the webpage is being loaded WebDriver even can't locate the webElement as
// it's not a part of HTML. So, it's not hidden it does not exist until the webpage/webElement is being rendered/fully loaded.

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        //wait up to 20 seconds


        String message = driver.findElement(By.cssSelector("#finish")).getText();
        System.out.println(message);


    }

}
