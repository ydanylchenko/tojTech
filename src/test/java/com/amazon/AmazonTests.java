package com.amazon;

import com.amazon.pageObjects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class AmazonTests {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void tryPrimeTest() {
        AmazonStartPage startPage = new AmazonStartPage(driver);
        AmazonPrimePage primePage = startPage.clickTryPrimeNavBarLink();
        AmazonSignInPage signInPage = primePage.clickTryPrimeButton();
    }

    @Test
    public void addItemToCartTest() {
        AmazonStartPage startPage = new AmazonStartPage(driver);
        String itemName = "Poliviar Tea Kettle, 2.1 Quart Black Loud Whistle Food Grade Stainless Steel Teapot, Anti-Hot Handle and Anti-Rust, Suitable for All Heat Sources (JX2018-BL20)";
        startPage.setSearchKeyword(itemName);
        AmazonSearchResultsPage searchResultsPage = startPage.clickSearchButton();
        AmazonItemPage itemPage = searchResultsPage.clickItem(itemName);
        assertEquals("Title", "Amazon.com: " + itemName + ": Gateway", itemPage.getItemPageTitle());
        itemPage.clickAddToCartButton();
        AmazonCartPage cartPage = itemPage.clickViewCartButton();
        assertTrue("Item name", cartPage.isItemInCart(itemName));
        assertTrue("Item name", cartPage.isItemInCartOption2(itemName));
        assertEquals("Item price", "$31.99", cartPage.getItemPriceByName(itemName));
        assertEquals("Item quantity", "1", cartPage.getItemQuantityByName(itemName));
    }

    @Test
    public void careersPageTest() {
        AmazonStartPage startPage = new AmazonStartPage(driver);
        AmazonCareersPage careersPage = startPage.clickCareersLink();
    }

    @Test
    public void careersPageTest_OLD() {
        AmazonStartPage startPage = new AmazonStartPage(driver);
        AmazonCareersPage careersPage = startPage.clickCareersLink();
    }

    @Test
    public void notExistingItemSearchTest() {
        AmazonStartPage startPage = new AmazonStartPage(driver);
        String itemName = "someNotExistingItemName";
        startPage.setSearchKeyword(itemName);
        AmazonSearchResultsPage searchResultsPage = startPage.clickSearchButton();
        assertEquals("Title", "Amazon.com: " + itemName, searchResultsPage.getSearchResultsPageTitle());
        assertTrue("No search results message", searchResultsPage.isNoSearchResultMessageDisplayed(itemName));
    }

    @Test
    public void updateItemQuantityInCartTest() {
        AmazonStartPage startPage = new AmazonStartPage(driver);
        String itemName = "Poliviar Tea Kettle, 2.1 Quart Black Loud Whistle Food Grade Stainless Steel Teapot, Anti-Hot Handle and Anti-Rust, Suitable for All Heat Sources (JX2018-BL20)";
        startPage.setSearchKeyword(itemName);
        AmazonSearchResultsPage searchResultsPage = startPage.clickSearchButton();
        AmazonItemPage itemPage = searchResultsPage.clickItem(itemName);
        itemPage.clickAddToCartButton();
        AmazonCartPage cartPage = itemPage.clickViewCartButton();
        assertTrue("Item name", cartPage.isItemInCartOption2(itemName));
        assertEquals("Item price", "$31.99", cartPage.getItemPriceByName(itemName));
        assertEquals("Item quantity", "1", cartPage.getItemQuantityByName(itemName));
        assertEquals("Cart subtotal", "$31.99", cartPage.getCartSubtotal());
        cartPage = cartPage.deleteItemFromCart(itemName);
        assertFalse("Item name", cartPage.isItemInCartOption2(itemName));
    }
}
