package com.cybertek.tests.day4_basic_locators;


import io.github.bonigarcia.wdm.WebDriverManager; //We downloaded WDM to pom.xml file as a dependency to be able to
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // import the binary codes of browsers to the class we create
                                      //whenever we call it, WDM imports browsers' .exe files to the class
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ahmedSelfStudy {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); //Chrome browser is ready for automation
        WebDriver driver = new ChromeDriver(); //Polymorphic object creation

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.tagName("input"));
        fullNameInputBox.sendKeys("Mike Smith Tag Name");

        Thread.sleep(3000);
        System.out.println("fullNameInputBox = " + fullNameInputBox.getText());


        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("mike@smith.com");

        Thread.sleep(1000);
        System.out.println("email = " + email.getText());


    }





}
