package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class alerts {
    public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys("Kali Uchis");
        driver.findElement(By.id("alertbtn")).click();
        //Validates if there is an alert on the page
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();
    }
}
