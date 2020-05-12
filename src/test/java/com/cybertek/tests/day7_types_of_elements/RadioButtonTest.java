package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void radioBtnTest1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        // how to check if radio button is selected?

        System.out.println("blueRadioButton.isSelected" + blueRadioButton);
        System.out.println("redRadioButton.isSelected" + redRadioButton);

        //TASK verify blue is selected res is not selected
        Assert.assertTrue(blueRadioButton.isSelected(), "verify blue is selected");
        Assert.assertFalse(redRadioButton.isSelected(), "verify is not selected");

        //how to select the radio buttton?
        //we use click method to do so
        redRadioButton.click();

        //verify blue is not selected and red is selected
        Assert.assertFalse(blueRadioButton.isSelected(), "verify blue is not selected");
        Assert.assertTrue(redRadioButton.isSelected(), "verify red is selected");

        driver.quit();



    }







}
