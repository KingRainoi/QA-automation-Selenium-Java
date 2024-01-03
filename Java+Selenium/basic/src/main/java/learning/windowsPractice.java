package learning;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class windowsPractice {
    public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        // Navigate to the login page of the application
        driver.get("https://the-internet.herokuapp.com/");

        //Find the multiple windows option and click it
        driver.findElement(By.linkText("Multiple Windows")).click();

        //Find and click the click here link
        driver.findElement(By.linkText("Click Here")).click();

        //Get the window handles of the parent and child window
        Set<String> windows =  driver.getWindowHandles();

        //Get child and parent windows
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();

        //Switch to the child window
        driver.switchTo().window(childWindow);

        //Print the text in the child window
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        
        //Go back to the parent window
        driver.switchTo().window(parentWindow);
        
        //Print the text in the parent window
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}
