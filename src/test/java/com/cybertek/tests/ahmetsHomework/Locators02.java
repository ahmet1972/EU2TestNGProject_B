package com.cybertek.tests.ahmetsHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Locators02 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void aftermethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
       driver.get("https://www.ebay.co.uk/");

       //WebElement searchBox = driver.findElement(By.id("gh-ac"));
       //WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
       WebElement searchBox = driver.findElement(By.cssSelector("input#gh-ac"));
       searchBox.sendKeys("ipad");

       //WebElement searchButton = driver.findElement(By.id("gh-btn"));
       //WebElement searchButton = driver.findElement(By.xpath("//input[@id='gh-btn']"));
       WebElement searchButton = driver.findElement(By.cssSelector("input.btn.btn-prim.gh-spr"));
       searchButton.click();

       WebElement results = driver.findElement(By.xpath("//*[text()=' results for ']/span[1]"));
        System.out.println(results.getText());
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");
        Thread.sleep(1000);
        driver.get("https://www.ebay.co.uk/");

        //WebElement searchBox = driver.findElement(By.id("gh-ac"));
        //WebElement searchBox = driver.findElement(By.xpath("//input[@name='_nkw']"));
        WebElement searchBox = driver.findElement(By.cssSelector("input#gh-ac"));
        searchBox.sendKeys("ipad");

        WebElement searchButton = driver.findElement(By.cssSelector("input.btn.btn-prim.gh-spr"));
        searchButton.click();

        Assert.assertTrue(driver.getTitle().contains("search"));
    }

    @Test
    public void test3() throws InterruptedException {

        driver.get("https://www.wikipedia.org");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");

        driver.findElement(By.xpath("//i[.='Search']")).click(); //>  /html/body/div[2]/form/fieldset/button/i

        driver.findElement(By.linkText("Selenium (software)")).click();

        String url= driver.getCurrentUrl();
        System.out.println(url);

        String[]urls = url.split("/");
        String expected= "Selenium_(software)";

        for(String str: urls){
            if(str.equalsIgnoreCase(expected)){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
            }
        }

    }



}
