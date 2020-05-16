package com.cybertek.tests.ahmetsHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day10_Homework_6 {

    WebDriver driver;
    @BeforeMethod
    public void before(){
        driver= WebDriverFactory.getDriver("chrome");


    }
    @AfterMethod
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        // driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.tempmailaddress.com");

        String email = driver.findElement(By.id("email")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        driver.findElement(By.name("full_name")).sendKeys("Mike");

        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.name("wooden_spoon")).click();

        String expectedText= "Thank you for signing up. Click the button below to return to the home page.";

        String actualText= driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actualText,expectedText);

        Thread.sleep(2000);

        driver.get("https://www.tempmailaddress.com");

        String expectedfrom = "do-not-reply@practice.cybertekschool.com";
        String actualfrom = driver.findElement(By.className("from")).getText().trim();
        Assert.assertEquals(actualfrom,expectedfrom);

        driver.findElement(By.className("from")).click();
        Thread.sleep(2000);

        String expectedfrom2= "do-not-reply@practice.cybertekschool.com";
        String actualfrom2 = driver.findElement(By.id("odesilatel")).getText();
        Assert.assertEquals(actualfrom2,expectedfrom2);

        String expectedSubject= "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(actualSubject,expectedSubject);



    }
}