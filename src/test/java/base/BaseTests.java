package base;

import etiya.crm.pages.BasePage;
import etiya.crm.pages.SearchCustomerPage;
import etiya.crm.pages.LoginPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static etiya.crm.pages.BasePage.delay;



public class BaseTests {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected SearchCustomerPage searchCustomerPage;
    protected WebDriverWait wait;
    private String url = "http://localhost:4301";
    protected SoftAssertions softAssertions;



    @Before
    public void setUp() {
        driver= new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get(url);
        softAssertions = new SoftAssertions();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Nesnelerin başlatılması
        basePage = new BasePage();
        basePage.setDriver(driver);
        login();



    }

    protected void login() {
        loginPage = new LoginPage();
        // Burada giriş yapmak için gerekli olan bilgileri tanımlayın
        searchCustomerPage =loginPage.logIntoApplication("firstName.lastName@gmail.com","Abc12345");
        searchCustomerPage.setDriver(driver);
         }

    @After
    public void tearDown() {
        delay(3000);  // Wait for 3 seconds before closing the browser
        driver.quit();
        softAssertions.assertAll();
    }
}


