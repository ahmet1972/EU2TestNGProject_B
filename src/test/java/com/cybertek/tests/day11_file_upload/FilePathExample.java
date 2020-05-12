package com.cybertek.tests.day11_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test(){

        //Below line will retrieve what operating system our computer uses because of getProperty Class
        //WE NEED TO USE getProperty CLASS TO ACHIEVE TO RETRIEVE THE DYNAMIC PATH
        System.out.println(System.getProperty("os.name"));

       //Getting Location of the Project location in a Dynamic Way (Dynamic Path)
       //We need to get the dynamic path as everyone may store the project files in different locations in their computers.
       String projectPath = System.getProperty("user.dir");
       System.out.println("projectPath = " + projectPath);

       //Getting the Relative Path which is Static ( Because everyone has the same project package and file structure
       // in IntelliJ. So, the path from project folder to the location of the file should be the same for everyone
       // in IntelliJ. We get the relative path by right click on the relative file and choose copy path then
       // choose "Path from Content Root"
       String relativePath = "src/test/resources/testfile.txt";


       String filePath = projectPath+"/"+relativePath;
        System.out.println("filePath = " + filePath);

    }





}
