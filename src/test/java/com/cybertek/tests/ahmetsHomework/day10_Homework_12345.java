package com.cybertek.tests.ahmetsHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class day10_Homework_12345 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void aftermethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    /*
    Test case #1
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter “wrong_dob” into date of birth input box.
        Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     */
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement RegistrationForm = driver.findElement(By.xpath("//a[@href='/registration_form']"));
        //driver.findElement(By.xpath("//*[.='Registration Form'][2]"));
        RegistrationForm.click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");
        String actualResult = driver.findElement(By.xpath("//*[.='The date of birth is not valid']")).getText();
        String expectedResult = "The date of birth is not valid";

        Assert.assertEquals(actualResult, expectedResult);
    }


    /*
    Test case #2
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
     */
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement RegistrationForm = driver.findElement(By.xpath("//a[@href='/registration_form']"));
        //driver.findElement(By.xpath("//*[.='Registration Form'][2]"));
        RegistrationForm.click();
        Thread.sleep(2000);

        List<WebElement> languages = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']"));
        System.out.println("languages.size() = " + languages.size());

        for(WebElement language: languages){
            Assert.assertTrue(language.isDisplayed());// this statement does not print when it's in the loop. That's
                                                    // why next line is added
            System.out.println(language.getText() + " is displayed,right? " + language.isDisplayed());
        }

    }

    /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into ﬁrst name input box.
        Step 4. Verify that warning message is displayed:“first name must be more than 2 and less than 64 characters long”

         */

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement RegistrationForm = driver.findElement(By.xpath("//a[@href='/registration_form']"));
        //driver.findElement(By.xpath("//*[.='Registration Form'][2]"));
        RegistrationForm.click();
        Thread.sleep(2000);

        WebElement firstname = driver.findElement(By.cssSelector("input[name='firstname']"));
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("a");

        String expected = "first name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//*[text()='first name must be more than 2 and less than 64 characters long']")).getText();
        Assert.assertEquals(actual, expected);
    }
    /*
    Test case #4
    Step1. Go to https://practice-cybertekschool.herokuapp.com
    Step2. Click on “Registration Form”
    Step3. Enter only one alphabetic character into last name input box.
    Step4. Verify that warning message is displayed:“The last name must be more than 2 and less than 64 characters long”
     */
    @Test
    public void test4() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement RegistrationForm = driver.findElement(By.xpath("//a[@href='/registration_form']"));
        //driver.findElement(By.xpath("//*[.='Registration Form'][2]"));
        RegistrationForm.click();
        Thread.sleep(2000);

        WebElement lastname = driver.findElement(By.name("lastname"));
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("a");

        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//*[.='The last name must be more than 2 and less than 64 characters long']")).getText();
        Assert.assertEquals(actual, expected);
    }

    /*
Test case #5
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid ﬁrst name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
Note: for using dropdown, please refer to the documentation:
https://selenium.dev/selenium/ docs/api/java/org/openqa/selenium/support/ui/ Select.html or,
please watch short video about drop-downs that is posted on canvas.
     */
    @Test
    public void test5(){

        WebDriverWait wait = new WebDriverWait(driver,10);// driver object is being passed as an
                                    //argument. Why? What would be its effect to the following code in the class

        // wait.until(ExpectedConditions.visibilityOf(usernamebox));

        WebElement registration_form = driver.findElement(By.linkText("Registration Form"));
        registration_form.click();
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Mustafa");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Irice");

        driver.findElement(By.name("username")).sendKeys("mustafa");

        driver.findElement(By.name("email")).sendKeys("mustafairice@hotmail.com");

        driver.findElement(By.name("password")).sendKeys("mustafa1234");

        driver.findElement(By.name("phone")).sendKeys("770-368-2729");

        driver.findElement(By.cssSelector("[value='male']")).click();

        WebElement birthdaybox = driver.findElement(By.name("birthday"));
        birthdaybox.sendKeys("02/03/1990");

//        driver.findElement(By.name("department")).click();
//
//        List<WebElement> dropdownOptions = driver.findElements(By.name("department"));
//
//        for (WebElement dropdownOption : dropdownOptions) {
//            System.out.println(dropdownOption.getText());
//        }
        WebElement dropDowndepart = driver.findElement(By.name("department"));

        Select departDropdown= new Select(dropDowndepart);

        List<WebElement> options = departDropdown.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        departDropdown.selectByIndex(1);
        System.out.println("=====================");

        WebElement dropDownjob = driver.findElement(By.name("job_title"));

        Select jobDropdown= new Select(dropDownjob);
        List<WebElement> options2 = jobDropdown.getOptions();
        for (WebElement option : options2) {
            System.out.println(option.getText());
        }
        jobDropdown.selectByVisibleText("SDET");
        //jobDropdown.selectByValue("SDET");

        driver.findElement(By.id("inlineCheckbox2")).click();

        driver.findElement(By.id("wooden_spoon")).click();

        String expected="You've successfully completed registration!";
        String actual= driver.findElement(By.xpath("//p")).getText();

        Assert.assertEquals(actual,expected);
    }

    @DataProvider(name="CreateData")
    public Object[][] CreateData(){
        Object[][] data= new Object[2][3];
        data[0][0]="firstname";
        data[0][1]="first name must be more than 2 and less than 64 characters long";
        data[0][2]="//*[.='first name must be more than 2 and less than 64 characters long']";
        data[1][0]="lastname";
        data[1][1]="The last name must be more than 2 and less than 64 characters long";
        data[1][2]="//*[.='The last name must be more than 2 and less than 64 characters long']";

        return data;
    }

    @Test(dataProvider = "CreateData")
    public void test6(String locator1,String expected,String locator2){

        WebElement registration_form = driver.findElement(By.linkText("Registration Form"));
        registration_form.click();

        WebElement lastname = driver.findElement(By.name(locator1));
        lastname.sendKeys("I");

        WebElement invalidtext= driver.findElement(By.xpath(locator2));
        String actual = invalidtext.getText();
        Assert.assertEquals(actual,expected);
    }

}


