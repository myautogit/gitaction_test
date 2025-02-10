package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.qa.utils.utilities.takeScreenshot;

public class MyTest {

    @Test()
    public void myTestMethod() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        System.out.println("Test1 - navigate to google.com");
        Assert.assertTrue(1 == 1, "Test Passed");
        System.out.println("Test1 completed - test to pass");
        Allure.step("This is Allure step - test1 navigate to google.com completed");
        driver.quit();
    }
    @Test()
    public void myTestMethod2() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        takeScreenshot("test2", driver);

        System.out.println("Hello World2");
        SoftAssert softAssert = new SoftAssert();
                softAssert.assertTrue(1 == 2, "Test Failed");
        System.out.println("Test2 completed - test to fail");
        Allure.step("This is Allure step - test2 hello world completed");
        driver.quit();
        softAssert.assertAll();
    }
}
