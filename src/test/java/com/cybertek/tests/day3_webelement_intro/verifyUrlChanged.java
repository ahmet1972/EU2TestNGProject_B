package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {

    public static void main(String[] args) {

    /**
     * Verify URL changed
     * open chrome browser
     * go to http://practice.cybertekschool.com/forgot_password (http://practice.cybertekschool.com/forgot_password)
     * enter any email
     * click on Retrieve password
     * verify that url changed to http://practice.cybertekschool.com/email_sent
     */

    //open chrome
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    //navigate to url
    driver.get("http://practice.cybertekschool.com/forgot_password");

    //find email input box
    WebElement emailInputBox = driver.findElement(By.name("email"));

    // sendKeys() --> send -keyboard action- to the WebElement
    emailInputBox.sendKeys("test@gmail.com");

    WebElement retrievePasswordBtn = driver.findElement(By.id("form_submit"));
    retrievePasswordBtn.click();

    //verify that url changed to http://practice.cybertekschool.com/email_sent
    String expectedUrl = "to http://practice.cybertekschool.com/email_sent";

    //get current url browser and save as an actual
    String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);

        }
        //close browser after everything
        driver.quit();



    }
}