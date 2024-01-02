package learning;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fluentWait {
      public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        driver.get("");

    }
}
