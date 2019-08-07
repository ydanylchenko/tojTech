package com.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonCareersSearchResultsPage {
    WebDriver driver;

    AmazonCareersSearchResultsPage(WebDriver webDriver) {
        driver = webDriver;
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("Job search | Amazon.jobs"));
    }

    public AmazonCareersJobPage clickJobTitle(String jobTitle) {
        By jobTitleLocator = By.xpath(String.format("//h3[.='%s']", jobTitle));
        driver.findElement(jobTitleLocator).click();
        return new AmazonCareersJobPage(driver);
    }
}
