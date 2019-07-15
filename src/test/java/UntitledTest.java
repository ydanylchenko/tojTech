import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class UntitledTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void untitled() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(1000);
        assertEquals("Home page title", "Google", driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("seleniumqh");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        assertEquals("Search results page title", "seleniumqh - Google Search", driver.getTitle());
        driver.findElement(By.xpath("//span[.='Showing results for']/..//i")).click();
        Thread.sleep(1000);
        assertEquals("Search results page title", "seleniumqh - Google Search", driver.getTitle());
        driver.findElement(By.xpath("//h3[.='Selenium - Web Browser Automation']")).click();
        Thread.sleep(1000);
        assertEquals("SeleniumHQ page title", "Selenium - Web Browser Automation", driver.getTitle());
    }
}
