package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class locators {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();

        System.setProperty("webdriver.gecko.driver", "C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

        driver.get("https://www.youtube.com");
        
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("The Weeknd - Starboy (Gojo AI Cover)");
        searchBox.submit();

        // Use WebDriverWait to wait for search results
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("video-title")));

        // Click on the first video in the search results
        //WebElement firstVideo = driver.findElement(By.id("video-title"));
        WebElement firstVideo = driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string"));
        System.out.println("\n\n\nnow im going to click the first video\n\n\n\n");
        firstVideo.click();

        // Wait for the video player to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".html5-video-container")));

        WebElement videoPlayer = driver.findElement(By.cssSelector(".ytp-large-play-button.ytp-button"));
        videoPlayer.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("video-title")));
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("video-title")));
        String textoH1 = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(textoH1, "The Weeknd - Starboy (Gojo AI Cover)");

        System.out.println("\n\nnow im going to click the share button\n\n");
        WebElement shareButton = driver.findElement(By.xpath("//button[@aria-label='Share']"));        
        shareButton.click();

        try {
            Thread.sleep(Duration.ofSeconds(10)); // Wait for 10 seconds before closing the browser (example)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}