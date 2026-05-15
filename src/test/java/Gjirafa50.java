import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Gjirafa50 {
    public void setup(WebDriver driver){
        driver.get("https://gjirafa50.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Kompjuter, Laptop & Monitor")).click();
        driver.findElement(By.linkText("Kompjuter")).click();
        driver.findElement(By.xpath("//input[@name='priceChange']")).sendKeys("1000");
        driver.findElement(By.xpath("//input[@class='w-full to-price']")).sendKeys("3500");
        driver.findElement(By.xpath("//button[@class='btn-simple py-1 px-2 border-primary hover:bg-primary hover:text-white text-primary submit-price-range w-full']")).click();
        driver.findElement(By.xpath("//input[@id='hasLocalStockInput']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("price="));

    }
    @Test
        public void correctURL() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        setup(driver);
        String expectedURL = "https://gjirafa50.com/kompjuter?pagenumber=1&orderby=&hls=true&is=false&price=1000-3500";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL, "SUCCESS: Actual URL matches the Expected URL." + "Expected: " + expectedURL + "Actual: " + currentURL);
        driver.quit();
     }
    @Test
        public void  incorrectURL() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        setup(driver);
        String expectedURL = "https://gjirafa50.com/kompjuter?pagenumber=1&orderby=&hls=true&is=false&price=1005-3500";
        String currentURL = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedURL, currentURL, "FAIL: URLs do not match");
        driver.quit();
     }
    }
