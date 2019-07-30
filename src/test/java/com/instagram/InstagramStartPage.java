package com.instagram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class InstagramStartPage {
    WebDriver driver;

    InstagramStartPage(WebDriver webDriver) {
        driver = webDriver;
        assertEquals("Instagram", driver.getTitle());
    }

    public void setFullName(String fullName) {
        driver.findElement(By.name("fullName")).sendKeys(fullName);
    }

    public void setUserName(String userName) {
        driver.findElement(By.name("username")).sendKeys(userName);
    }

    public void clickSignUp() {
        driver.findElement(By.xpath("//button[.='Sign up']")).click();
    }

    public InstagramLoginPage clickLogIn() {
        driver.findElement(By.xpath("//a[.='Log in']")).click();
        return new InstagramLoginPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(By.id("ssfErrorAlert")).getText();
    }

}
