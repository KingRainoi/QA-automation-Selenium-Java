package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ComponentUtilities.abstractComponents;

public class LoginPage extends abstractComponents{
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Factory
    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;    

    @FindBy(id = "login")
    WebElement loginButton;

    public void loginIntoApplication(String email,String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

}
