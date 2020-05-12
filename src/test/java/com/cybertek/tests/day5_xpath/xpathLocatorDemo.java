package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xpathLocatorDemo {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http/:cybertekschoolcom/sign_up");

        WebElement button2 = driver.findElement(By.xpath("button[@class='radius']"));

        button2.click();



    }


}
