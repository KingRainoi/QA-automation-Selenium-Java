package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class practice2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("Kali Uchis");
        driver.findElement(By.name("email")).sendKeys("linux@gmail.com");
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("UchisUnix14#");
        driver.findElement(By.id("exampleCheck1")).click();

        WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select genderOption = new Select(genderDropdown);
        genderOption.selectByIndex(0);

        driver.findElement(By.xpath("//input[@value='option1']")).click();
        driver.findElement(By.name("bday")).click();
        driver.findElement(By.name("bday")).sendKeys("15062002");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        System.out.println(driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());
    }  
}
