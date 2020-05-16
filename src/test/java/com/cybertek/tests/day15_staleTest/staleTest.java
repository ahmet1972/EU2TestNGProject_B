package com.cybertek.tests.day15_staleTest;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

class StaleTest extends TestBase { // Why it doesn't accept public access modifier?????????????

    @Test
    public void test1(){
        driver.get("https://www.google.com");

        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Selenium"+Keys.ENTER);

        WebElement results = driver.findElement(By.id("result-stats"));
        Assert.assertTrue(results.isDisplayed());

        //go to google again
        driver.navigate().back();
        input = driver.findElement(By.name("q"));//we repeat the same line on 16 because of the staleElementException
        input.sendKeys("Java"+Keys.ENTER);
        results = driver.findElement(By.id("result-stats"));

        Assert.assertTrue(results.isDisplayed());

    }


}





