package POM;

import org.openqa.selenium.WebDriver;

import ComponentUtilities.abstractComponents;

public class ShoopingCartPage extends abstractComponents{
    WebDriver driver;

    public ShoopingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    
}
