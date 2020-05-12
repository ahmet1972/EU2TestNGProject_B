package com.cybertek.tests.day11_file_upload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ahmet111 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.get("https://www.google.com");
        //driver.manage().window().fullscreen();

        System.out.println(driver.getTitle());

//        driver.findElement(By.xpath())


    }
}
