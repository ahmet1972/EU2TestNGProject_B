package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {

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
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        //Actions --> it's a class that contains all the user interactions
        //We create and object from Actions class to be able to use its methods for actions
        // In order to create a connection between current class and actions object we pass the "driver" as an argument
        // to Action classes constructor.  We did this before for Wait Class

        //This is simply passing an abject as an argument to another object to achieve the connection. We should repeat
        //this step for each Test
        Actions actions = new Actions(driver);

        Thread.sleep(2000);

        //moveToElement--> move your mouse to webElement(hover over)
        //perform() --> perform/complete the action. We should add perform() method after every Actions class methods.
        actions.moveToElement(img1).perform();

        //When hover over the webElement two new webElements are displayed. So, we can utilize them if above action is
        // successfully executed. To do that we choose "View profile" WebElement. First we locate it, then we will
        //check if it's displayed with the help of assertTrue() method.
        WebElement link = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(link.isDisplayed(),"verify View profile link is displayed");
    }

    @Test
    public void DragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        Thread.sleep(2000);

        //Clicking to accept cookies. If you have a small screen you might not be able to drag and drop as
        // "Accept Cookies" notification covers the WebElement to be dragged.
        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        Thread.sleep(2000);

        actions.dragAndDrop(source,target).perform();
    }

    @Test
    public void DragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        Thread.sleep(1000);
        //drag and drop without dragAndDrop() method

        //if you are chaining actions we add build() method before perform()
        //pause(2000) is just to see the action clearly.
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();

    }

}