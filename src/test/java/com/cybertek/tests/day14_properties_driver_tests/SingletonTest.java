package com.cybertek.tests.day14_properties_driver_tests;

import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test(){
        String s1 = Singleton.getInstance();
        //Reference Variable Name of the new object will return the value assigned above. This is called Singleton
        // Design Patern and we need it to use the Web Driver everywhere in our tests until we change it just
        // like below line.
        String s2 = Singleton.getInstance();
    }


}
