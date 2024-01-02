package learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shoppingcartV2 {
     public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //List of things to buy
        String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
        addProducts(driver,itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
    }
    
    //Method to add products to cart
    public static void addProducts(WebDriver driver, String[] items){
        //List of all the products available
        List<WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));
        for(int i=0;i<products.size();i++)
        {
            String product = products.get(i).getText();
            for(String item : items) {
                if(product.contains(item)) {
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                }
            }
        }
    }
}
