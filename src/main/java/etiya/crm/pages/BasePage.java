package etiya.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    public static WebDriver driver;
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;


    }

    protected WebElement find(By locator) {
       //return driver.findElement(locator);
       return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    protected void set(By locator, String text)  {
        find(locator).clear();
        find(locator).sendKeys(text);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        //find(locator).click();
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
