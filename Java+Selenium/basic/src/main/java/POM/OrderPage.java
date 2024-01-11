package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ComponentUtilities.abstractComponents;
import org.openqa.selenium.WebElement;

public class OrderPage extends abstractComponents{
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    @FindBy (css = ".hero-primary")
    WebElement confirmationMessage;

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
