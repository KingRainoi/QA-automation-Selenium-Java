package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class shettyacademy {
    public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.loginIntoApplication("anshika@gmail.com", "Iamking@000");

        ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);
        List<WebElement> products = productCataloguePage.getProductsList();
        productCataloguePage.addProductToCart("ZARA COAT 3");
    }
}
