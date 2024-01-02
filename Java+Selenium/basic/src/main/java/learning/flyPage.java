package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import org.openqa.selenium.By;

public class flyPage {
    public static void main(String[] args) { 

        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Save the dropwdown element
        //WebElement currencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //Select dropdown = new Select(currencyDropdown);
        //dropdown.selectByIndex(3);
        //System.out.println(dropdown.getFirstSelectedOption().getText());
        //dropdown.selectByVisibleText("AED");
        //System.out.println(dropdown.getFirstSelectedOption().getText());
        //dropdown.selectByValue("INR");
        //System.out.println(dropdown.getFirstSelectedOption().getText());

        //Passengers options
        //driver.findElement(By.id("divpaxinfo")).click();
        //try {
        //    Thread.sleep(Duration.ofSeconds(2)); // Wait for 10 seconds before closing the browser (example)
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //for(int i=0;i<=2;++i){
        //    driver.findElement(By.id("hrefIncAdt")).click();
        //}
        //  try {
        //    Thread.sleep(Duration.ofSeconds(1)); // Wait for 10 seconds before closing the browser (example)
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //driver.findElement(By.id("btnclosepaxoption")).click();
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        try {
            Thread.sleep(Duration.ofSeconds(4)); // Wait for 10 seconds before closing the browser (example)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_destinationStation1']//option[@value='ATQ'][normalize-space()='Amritsar (ATQ)']")).click();
    }
}
