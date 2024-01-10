package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class locators2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com.mx/");
        //driver.navigate().to("https://www.pinterest.com.mx/");
        driver.navigate().to("https://www.pinterest.com.mx/");

        WebDriverWait waitForPageToLoad = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForPageToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/ideas/']")));

        WebElement exploreButton = driver.findElement(By.xpath("//a[@href='/ideas/']"));
        exploreButton.click();

    }
}
