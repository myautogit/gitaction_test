package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyTest {

    @Test()
    public void myTestMethod() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        System.out.println("Hello World");
    }
}
