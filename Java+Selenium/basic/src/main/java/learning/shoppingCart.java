package learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shoppingCart {
     public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //List of things to buy
        String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};

        //List of all the products available
        List<WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));
        for(int i=0;i<products.size();i++)
        {
            String product = products.get(i).getText();
            for(String item : itemsNeeded) {
                if(product.contains(item)) {
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                }
            }
        }
    }
}
