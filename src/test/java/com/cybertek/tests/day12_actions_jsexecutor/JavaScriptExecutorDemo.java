package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void clickWithJS(){
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        //clicking with JavascriptExecutor Interface
        //create js executor polymorphic object (Parent must be WebDriver and child is JavascriptExecutor)
        //JavascriptExecutor comes from Selenium. We down-cast driver to JavascriptExecutor.
        //So, Webdriver should be parent of JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //use executeScript which is the only one we will use
        jse.executeScript("arguments[0].click();",dropdownLink);
    }

    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputbox = driver.findElement(By.cssSelector("#input-example>input"));

        //inputbox.sendKeys("Some Texts"); //throws ElementNotInteractableException
        //That's why we try JS Executor for disabled input boxes. Look below.

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String str = "Hello disabled input";
        jse.executeScript("arguments[0].setAttribute('value', '"+str+"')",inputbox);
    }

    @Test
    public void scrollDownandUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;



        for (int i = 0; i < 10; i++) { // we just wanted to scroll down 10 times.
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0, 250);");//We don't need to include WebElement as we scroll
                                                                //up-down the whole page.

        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0, -250);");

        }


    }

}