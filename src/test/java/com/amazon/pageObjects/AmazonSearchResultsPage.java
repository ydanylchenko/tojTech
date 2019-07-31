package com.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchResultsPage {
    WebDriver driver;

    AmazonSearchResultsPage(WebDriver webDriver) {
        driver = webDriver;
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Amazon.com: "));
    }

    public AmazonItemPage clickItem(String itemName) {
        By itemNameLocator = By.xpath("//span[.='" + itemName + "']");
        driver.findElement(itemNameLocator).click();
        return new AmazonItemPage(driver);
    }
}
