package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ComponentUtilities.abstractComponents;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CheckOutPage extends abstractComponents{

    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".action__submit")
    WebElement placeOrderButton;

    @FindBy(css="[placeholder='Select Country']")
    WebElement countryDropdown;

    @FindBy(xpath = "//button[contains(@class,'ta-item')])[2]")
    WebElement selectCountry;

    By results = By.cssSelector(".ta-results");

    public void selectCountry(String countryName) {
        Actions action = new Actions(driver);
        action.sendKeys(countryDropdown, countryName).build().perform();
        waitForElementToAppear(results);
        selectCountry.click();
    }

    public OrderPage placeOrder() {
        placeOrderButton.click();
        return new OrderPage(driver);
    }
    
}
