package com.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonItemPage {
    WebDriver driver;

    AmazonItemPage(WebDriver webDriver) {
        driver = webDriver;
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Amazon.com: "));
    }

    public String getItemPageTitle() {
        return driver.getTitle();
    }

    public void clickAddToCartButton() {
        By addToCartButton = By.id("add-to-cart-button");
        driver.findElement(addToCartButton).click();
    }

    public AmazonCartPage clickViewCartButton() {
        By viewCartButton = By.className("cart-btn");
        driver.findElement(viewCartButton).click();
        return new AmazonCartPage(driver);
    }
}