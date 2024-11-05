package utilities;

import etiya.crm.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class Utility {
    public static WebDriver driver;

    public static void setUtilityDriver() {
        driver= BasePage.driver;

        //Can generate random numbers
        //return strings to upper case

    }
}
