package org.craigslist.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CraigslistSearchResultsPage {
    WebDriver driver;

    CraigslistSearchResultsPage(WebDriver browser) {
        driver = browser;
        WebDriverWait wait = new WebDriverWait(driver, 2);
        //div[@id='sortable-results']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sortable-results")));
    }

    public CraigslistSearchResultsPage selectArea(String area){
        By areaSelectLocator = By.id("areaAbb");
        WebElement areaSelectElement = driver.findElement(areaSelectLocator);
        Select areaSelect = new Select(areaSelectElement);
        areaSelect.selectByVisibleText(area);
        return new CraigslistSearchResultsPage(driver);
    }
}
