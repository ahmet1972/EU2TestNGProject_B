package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
    public void switchWindowsTest() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        System.out.println("Title before new window: "+driver.getTitle());
        //click click here link
        Thread.sleep(1000);
        driver.findElement(By.linkText("Click Here")).click();
        //get title again
        Thread.sleep(1000);

        System.out.println("Title after new window: "+driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        //we will switch to new window
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("windowHandles = " + windowHandles.size());

        for (String handle : windowHandles) {
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }

        System.out.println("Title after switching window: "+driver.getTitle());
    }

    @Test
    public void moreThan2Window () {
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        //loop through each window
        for (String handle : windowHandles) {
            //one by one
            driver.switchTo().window(handle);

            //once the title is equal to expected window title
            if(driver.getTitle().equals("New Window")){
                //stop switching windows. You are at the right window
                break;
            }
        }

        System.out.println("Title after switching window: "+driver.getTitle());

        System.out.println(driver.findElement(By.tagName("h3")).getText());



    }
}