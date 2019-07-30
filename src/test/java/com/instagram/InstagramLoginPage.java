package com.instagram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class InstagramLoginPage {
    WebDriver driver;

    InstagramLoginPage(WebDriver webDriver) {
        driver = webDriver;
//        BAD OPTION 1:
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        assertEquals("Login • Instagram", driver.getTitle());
//        BETTER OPTION 2:
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("Login • Instagram"));
    }
}
