package learning;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;

public class dragAndDrop {
    public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        // Navigate to the login page of the application
        driver.get("https://jqueryui.com/droppable/");

        // Click on the Drag and Drop link
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));    
        WebElement target = driver.findElement(By.id("droppable"));

        action.dragAndDrop(source, target).build().perform();;
    }
}
