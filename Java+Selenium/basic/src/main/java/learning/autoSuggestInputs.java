package learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class autoSuggestInputs {
    public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        try {
            Thread.sleep(Duration.ofSeconds(3)); // Wait for 10 seconds before closing the browser (example)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement option :options)
        {

            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;

            }
        }

        try {
            Thread.sleep(Duration.ofSeconds(1)); // Wait for 10 seconds before closing the browser (example)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Checkboxes
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=StudentDiscount]")).isSelected());
        driver.findElement(By.cssSelector("input[id*=StudentDiscount]")).isSelected();
        
        driver.findElement(By.cssSelector("input[id*=StudentDiscount]")).click();
        
        //System.out.println(driver.findElement(By.cssSelector("input[id*=StudentDiscount]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=StudentDiscount]")).isSelected());
        driver.findElement(By.cssSelector("input[id*=StudentDiscount]")).isSelected();

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
    
        
    }
    
}
