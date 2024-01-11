package ComponentUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractComponents {

    protected WebDriver driver;
    protected WebDriverWait wait; 

    public abstractComponents(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public void waitForElementToAppear(By findBy) { 
        this.wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void waitForElementToDisappear(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToDisappear() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
}
