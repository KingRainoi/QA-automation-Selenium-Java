package learning;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Calendar2 {
    public static void main(String[] args) throws InterruptedException { 
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

        
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.findElement(By.id("form-field-travel_comp_date")).click();
        //WebElement datehardcoded = driver.findElement(By.xpath("//span[text()='9']"));
        //datehardcoded.click();

        //January 9th
        List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day:not(.disabled)"));

        // Using Iterator to safely remove elements
        Iterator<WebElement> iterator = dates.iterator();
        while (iterator.hasNext()) {
            WebElement date = iterator.next();
            String classNameDate = date.getAttribute("class");
            if (classNameDate.contains("MonthDay")) {
                iterator.remove();
            }
        }

        // Select the date
        for (WebElement date : dates) {
            if (date.getText().equals("9")) {
                date.click();
            }
        }

        //Codio del rahulshty
        // TODO Auto-generated method stub

        //System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
        //ChromeDriver driver = new ChromeDriver();
        //driver.get("https://www.path2usa.com/travel-companions");
        // April 23
        //driver.findElementByXPath(".//*[@id='travel_date']").click();

        //while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
        //        .contains("May")) {
        //    driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        //}

        //List<WebElement> dates = driver.findElements(By.className("day"));
        // Grab common attribute//Put into list and iterate
        //int count = driver.findElements(By.className("day")).size();

        //for (int i = 0; i < count; i++) {
        //    String text = driver.findElements(By.className("day")).get(i).getText();
        //    if (text.equalsIgnoreCase("21")) {
        //        driver.findElements(By.className("day")).get(i).click();
        //        break;
        //    }

        //}
    }
}
