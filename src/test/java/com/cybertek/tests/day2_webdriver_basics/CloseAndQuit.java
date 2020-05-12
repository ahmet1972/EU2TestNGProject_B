package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        driver.get("http://practice.cybertekschool.com");
//
//        Thread.sleep(2000);
//
//        //close the current tab
//        driver.close();

        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        //close the current tab
//        driver.close();// if we typed this code on this line it would close the new tob only.
//        The main tab would still stay opened

        //close all the tabs regardless of who opened
        driver.quit();


    }
}
