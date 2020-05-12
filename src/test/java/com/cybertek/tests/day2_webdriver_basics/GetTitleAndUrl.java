package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium


        //get.Title --> get you the title of the page
        String title = driver.getTitle();  //first short-cut to introduce local variable --> alt + enter + enter

        System.out.println("title = " + title);  //second short-cut --> soutv + enter

        //getCurrentUrl() --> gets the current url of the page that selenium has navigated
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource --> gets the source code of the last page that has navigated (HTML)
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);



    }

}
