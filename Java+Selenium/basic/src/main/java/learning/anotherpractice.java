package learning;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class anotherpractice {
    public static void main(String[] args) { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        // Navigate to the login page of the application
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Select a checbox option
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();

        //Save the text of the checkbox
        String checkboxText =driver.findElement(By.cssSelector("label[for='bmw']")).getText();
        System.out.println(checkboxText);

        //Select the option of the dropdown wioth the same text of the checkbox
        WebElement dropdownOption = driver.findElement(By.id("dropdown-class-example"));
        Select option = new Select(dropdownOption);
        option.selectByVisibleText(checkboxText);

        //Enter the checkbox text inside the input
        driver.findElement(By.id("name")).sendKeys(checkboxText);
        driver.findElement(By.id("alertbtn")).click();

        //Verify the text of the alert
        String alertText = driver.switchTo().alert().getText();
        if(alertText.contains(checkboxText)){
            System.out.println("The text of the alert is correct");
        }
        else{
            System.out.println("The text of the alert is incorrect");
        }

        //Close the alrt
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
