package learning;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class nestedFramePractice {
    public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        // Navigate to the login page of the application
        driver.get("https://the-internet.herokuapp.com/");

        // Click on the nested frames link
        driver.findElement(By.linkText("Nested Frames")).click();
        
        // Switch to the top frame
        driver.switchTo().frame("frame-top");
        
        // Switch to the middle frame
        driver.switchTo().frame("frame-middle");
        
        // Print the text in the middle frame
        System.out.println(driver.findElement(By.tagName("body")).getText());
        
        driver.quit();  // Close the browser window and end the session.
    }
}
