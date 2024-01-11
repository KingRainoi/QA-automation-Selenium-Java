package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class shettyacademy {
    public static void main(String[] args) { 

        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductCataloguePage productCataloguePage = loginPage.loginIntoApplication("anshika@gmail.com", "Iamking@000");

        List<WebElement> products = productCataloguePage.getProductsList();
        productCataloguePage.addProductToCart("ZARA COAT 3");
        ShoppingCartPage shoppingCartPage = productCataloguePage.goToCart();

        boolean match = shoppingCartPage.verifyProductDisplay("ZARA COAT 3");
        Assert.assertTrue(match);
        
        CheckOutPage checkOutPage =  shoppingCartPage.goToCheckOut();
        checkOutPage.selectCountry("india");

        OrderPage orderPage = checkOutPage.placeOrder();
        String confirmMessage = orderPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();
    }
}
