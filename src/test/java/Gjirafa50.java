import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Gjirafa50 {
    @Test public void testName() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://gjirafa50.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Kompjuter, Laptop & Monitor")).click();
        driver.findElement(By.linkText("Kompjuter")).click();
        driver.findElement(By.xpath("//input[@name='priceChange']")).sendKeys("1000");
        driver.findElement(By.xpath("//input[@placeholder='5058']")).sendKeys("3500");
        driver.findElement(By.xpath("//button[@class='btn-simple py-1 px-2 border-primary hover:bg-primary hover:text-white text-primary submit-price-range w-full']")).click();
        driver.findElement(By.xpath("//input[@id='hasLocalStockInput']")).click();
        String expectedURL = "https://gjirafa50.com/kompjuter?pagenumber=1&orderby=&hls=true&is=false&price=1000-3500";
        String currentURL = "https://gjirafa50.com/kompjuter?pagenumber=1&orderby=&hls=true&is=false&price=1000-3500";
        Assert.assertEquals(expectedURL, currentURL, "FAIL: The actual URL does not match the expected URL." + "Expected: " + expectedURL + "Actual: " + currentURL);
        System.out.println("SUCCESS: Actual URL matches the Expected URL.");
        driver.quit();
    }
    }



