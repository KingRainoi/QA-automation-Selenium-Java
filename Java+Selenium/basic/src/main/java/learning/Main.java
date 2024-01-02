package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {

        // Launch Chrome browser
        //WebDriver driver = new ChromeDriver();
        
        //Launch firefox developer browser
        //System.setProperty("webdriver.gecko.driver", "C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();

        System.setProperty("webdriver.edge.driver", "C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.youtube.com/watch?v=N70DRo8_WwA&list=RDN70DRo8_WwA&start_radio=1");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        // Rest of your code to interact with the WebDriver instance (e.g., navigating
        // to a URL, interacting with elements)
        // ...

        // Close the browser window
        driver.quit();
    }
}