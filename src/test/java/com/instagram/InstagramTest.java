package com.instagram;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class InstagramTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void originalTest() {
        driver.get("https://www.instagram.com/");
        driver.findElement(By.name("fullName")).sendKeys("someFullNme");
        driver.findElement(By.name("username")).sendKeys("userName");
        driver.findElement(By.xpath("//button[.='Sign up']")).click();
        assertEquals("This username isn't available. Please try another.", driver.findElement(By.id("ssfErrorAlert")).getText());
    }

    @Test
    public void signUpTest() {
        driver.get("https://www.instagram.com/");
        InstagramStartPage startPage = new InstagramStartPage(driver);
        startPage.setFullName("ksdfvkjdfvndfklnvdfknvsdklv");
        startPage.setUserName("userName");
        startPage.clickSignUp();
        assertEquals("This username isn't available. Please try another.", startPage.getErrorMessage());
    }

    @Test
    public void logInTest() {
        driver.get("https://www.instagram.com/");
        InstagramStartPage startPage = new InstagramStartPage(driver);
        InstagramLoginPage loginPage = startPage.clickLogIn();
    }
}
