package com.cybertek.tests.day7_testNg;

import org.testng.annotations.*;

public class BeforeAfterTests {

    @Test
    public void test1(){
        System.out.println("This is my test one");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }

    @Test
    public void test3(){
        System.out.println("This is my test 3");
    }

    @BeforeMethod
    public void setUp(){
        //WebDriver part
        System.out.println("BEFORE METHOD HERE");
        System.out.println("Webdriver Part");
    }

    @AfterMethod
    public void tearDown(){
        //close browser, quit
        System.out.println("AFTER METHOD HERE");
        System.out.println("Webdriver Part");
    }

    @BeforeClass
    public void setUpClas(){
        System.out.println("--BEFORE CLASS--");
        System.out.println("--RUNS ONLY ONCE BEFORE EVERYTHING IN THE CLASS--");
    }

    @AfterClass
    public void setUpClass(){
        System.out.println("--AFTER CLASS--");
        System.out.println("--RUNS ONLY ONCE AFTER EVERYTHING IN THE CLASS--");
        System.out.println("GENERATE REPORT");
    }












}
