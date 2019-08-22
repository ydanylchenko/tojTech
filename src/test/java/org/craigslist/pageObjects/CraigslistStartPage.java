package org.craigslist.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CraigslistStartPage {
    WebDriver driver;

    public CraigslistStartPage(WebDriver browser) {
        driver = browser;
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.titleIs("craigslist: new york city jobs, apartments, for sale, services, community, and events"));
    }

    public void setSearchCriteria(String searchCriteria) {
        By searchCriteriaInputLocator = By.id("query");
        WebElement searchCriteriaInput = driver.findElement(searchCriteriaInputLocator);
        searchCriteriaInput.sendKeys(searchCriteria);
    }

    public CraigslistSearchResultsPage submit() {
        driver.findElement(By.id("query")).submit();
        return new CraigslistSearchResultsPage(driver);
    }
}
