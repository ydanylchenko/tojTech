package com.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class AmazonStartPage {
    WebDriver driver;

    public AmazonStartPage(WebDriver webDriver) {
        driver = webDriver;
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
    }

    public AmazonPrimePage clickTryPrimeNavBarLink() {
        By tryPrimeLinkLocator = By.className("nav-prime-try");
        driver.findElement(tryPrimeLinkLocator).click();
        return new AmazonPrimePage(driver);
    }

    public void setSearchKeyword(String keyword) {
        By searchInputLocator = By.id("twotabsearchtextbox");
        driver.findElement(searchInputLocator).sendKeys(keyword);
    }

    public AmazonSearchResultsPage clickSearchButton() {
        By searchButtonLocator = By.xpath("//input[@value='Go']");
        driver.findElement(searchButtonLocator).click();
        return new AmazonSearchResultsPage(driver);
    }
}
