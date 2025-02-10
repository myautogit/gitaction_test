package com.qa.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.qa.utils.AbstractDataLibrary.*;

public class utilities  {

    @Step("Taking Screenshot")
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(String testClassName, WebDriver driver) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(takeScreenshotPath + testClassName + "_" + timestamp + ".png"));
        } catch (IOException e) {
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
