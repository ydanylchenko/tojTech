package org.craigslist;

import org.craigslist.pageObjects.CraigslistSearchResultsPage;
import org.craigslist.pageObjects.CraigslistStartPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CraigslistTests {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://newyork.craigslist.org/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openSearchPage() {

        System.out.println("test");
        CraigslistStartPage startPage = new CraigslistStartPage(driver);
        startPage.setSearchCriteria("toaster");
        CraigslistSearchResultsPage searchResultsPage = startPage.submit();
        searchResultsPage = searchResultsPage.selectArea("boston");
        searchResultsPage = searchResultsPage.selectSubArea("metro west");
        searchResultsPage = searchResultsPage.clickSearchTitlesOnly();
        searchResultsPage = searchResultsPage.markSearchTitlesOnly(false);
        searchResultsPage = searchResultsPage.markSearchTitlesOnly(true);
    }
}
