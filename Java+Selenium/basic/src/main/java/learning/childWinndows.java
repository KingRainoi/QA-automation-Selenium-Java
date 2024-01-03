package learning;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.Set;
import java.util.Iterator;

public class childWinndows {
    public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        // Navigate to the login page of the application
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        //Click on the blinkling text
        driver.findElement(By.cssSelector(".blinkingText")).click();

        //Get the window handles of the parent and child window
        Set<String> windows =  driver.getWindowHandles();

        //Get child and parent windows
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();


        //Switch to the child window
        driver.switchTo().window(childWindow);

        //Get the text in red
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println(emailId);

        //Switch to the parent window
        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("username")).sendKeys(emailId);
    }
}
