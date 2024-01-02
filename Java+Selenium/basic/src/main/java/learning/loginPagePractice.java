package learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class loginPagePractice {
    public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        //Navigate to the login page of the application
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        //Enter username and poassword
        driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.name("password")).sendKeys("learning");

        //Select the user option
        driver.findElement(By.xpath("//input[@value='user']")).click();
        driver.findElement(By.id("okayBtn")).click();

        //Select the consultant option
        WebElement roleDropdown = driver.findElement(By.tagName("select"));
        Select roleOption = new Select(roleDropdown);
        roleOption.selectByIndex(2);

        //Mark the checkbox of terms and condition
        driver.findElement(By.id("terms")).click();

        //Login to the application
        driver.findElement(By.id("signInBtn")).click();

        //List of the items i want to buy
        String[] items = {"iphone X","Blackberry","Nokia Edge", "Samsung Note 8"};

        //Add the items to the cart
        addProducts(driver,items);

        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();

    }

    public static void addProducts(WebDriver driver, String[] items) {
        List<WebElement> products =  driver.findElements(By.cssSelector("h4.card-title"));
        for(int i=0;i<products.size();i++)
        {
            String product = products.get(i).getText();

            for(String item : items) {
                if(product.contains(item)) {
                    driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
                }
            }
        }
    }
}