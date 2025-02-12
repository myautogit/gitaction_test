package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static com.qa.utils.utilities.takeScreenshot;

public class MyTest {

    private WebDriver driver;
//    @BeforeClass
//    public WebDriver wdSetUp() throws MalformedURLException {
//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setPlatformName("Windows 10");
//        browserOptions.setBrowserVersion("132");
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", "hemal.shahmoodys");
//        ltOptions.put("accessKey", "oAWsprAnwyHH0kvb1tFhoZdyVeG3RR5FY32dRbSibFH5jjNmWM");
//        ltOptions.put("build", "selenium build");
//        ltOptions.put("project", "LambdaTestProj");
//        ltOptions.put("selenium_version", "4.0.0");
//        ltOptions.put("w3c", true);
//        browserOptions.setCapability("LT:Options", ltOptions);
//        driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"),browserOptions);
//        System.out.println("This is before class");
//        return driver;
//
//    }

    @Test(description = "This is a test to navigate to google.com")
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
        takeScreenshot("test1", driver);


        System.out.println("Test1 - navigate to google.com");
        Assert.assertTrue(1 == 1, "Test Passed");
        System.out.println("Test1 completed - test to pass");
        Allure.step("This is Allure step - test1 navigate to google.com completed");
        takeScreenshot("test1", driver);
        driver.quit();
    }
    @Test(description = "This is a test to navigate to sign in on BBC website")
    public void myTestMethod2() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.get("https://www.bbc.co.uk");
        takeScreenshot("test2", driver);

        Assert.assertTrue(driver.getTitle().contains("BBC"), "Test Passed");
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        takeScreenshot("test1", driver);

        System.out.println("navigate to bbc");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(1 == 2, "Test Failed");
        System.out.println("Test2 completed - test to fail");
        Allure.step("This is Allure step - test2 hello world completed");
        driver.quit();
        softAssert.assertAll();
    }
}