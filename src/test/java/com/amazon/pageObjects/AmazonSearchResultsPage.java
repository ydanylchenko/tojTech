package com.amazon.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public String getSearchResultsPageTitle() {
        return driver.getTitle();
    }

    public boolean isNoSearchResultMessageDisplayed(String itemName) {
        By noResultsMessageLocator = By.className("a-row");
        WebElement noResultsMessage = driver.findElement(noResultsMessageLocator);
        String expectedMessage = String.format("No results for %s.", itemName);
        Assert.assertEquals("No search results message", expectedMessage, noResultsMessage.getText());
        By hintElementLocator = By.xpath("//span[.='Try checking your spelling or use more general terms']");
        WebElement hintElement = driver.findElement(hintElementLocator);
        return noResultsMessage.isDisplayed() && hintElement.isDisplayed();
    }
}
