package com.cybertek.tests.day11_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test(){

        //Below line will retrieve what operating system our computer uses because of getProperty method from System
        //Class of Java
        System.out.println(System.getProperty("os.name"));

       //WE NEED TO USE getProperty CLASS TO ACHIEVE TO RETRIEVE THE DYNAMIC PATH (Location) of the our Project.
       //We need to provide the people with the path of our project files on our computer as we work together on a
       //project to enable them access our files when they need. Since everyone may store the project files in different
       //locations in their computers, we need provide them with a dynamic path that works at all times.
       String projectPath = System.getProperty("user.dir");
       System.out.println("projectPath = " + projectPath);

       //Getting the Relative Path which is Static ( Because everyone has the same project package and file structure
       // in IntelliJ. So, the path from project folder to the location of the file should be the same for everyone
       // in IntelliJ. We get the relative path by right click on the relative file and choose "copy path" then
       // choose "Path from Content Root"
       String relativePath = "src/test/resources/testfile.txt";


       String filePath = projectPath+"/"+relativePath;
        System.out.println("filePath = " + filePath);

    }





}
