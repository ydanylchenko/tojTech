package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonCartPage {
    WebDriver driver;

    AmazonCartPage(WebDriver webDriver) {
        driver = webDriver;
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("Amazon.com Shopping Cart"));
    }
}
