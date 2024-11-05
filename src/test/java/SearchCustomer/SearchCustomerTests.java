package SearchCustomer;

import base.BaseTests;
import etiya.crm.pages.CreateCustomerPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class SearchCustomerTests extends BaseTests {


    @Test
    public void testFiltersHeaderIsVisible() {
        softAssertions.assertThat(searchCustomerPage.isFiltersHeaderDisplayed())
                .isTrue();

    }

    @Test
    public void testSearchByIdNumber() {

        //Enter Id Number
        searchCustomerPage.setIdNumber("12345678901");
        //Wait and scroll

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                wait.until(ExpectedConditions.elementToBeClickable(searchCustomerPage.getSearchButton())));
        //
        searchCustomerPage.clickSearchButton();

        softAssertions.assertThat(searchCustomerPage.isResultsTableDisplayed())
                .as("Result table should be displayed")
                .isTrue();
    }

    @Test
    public void testSearchByCustomerId() {

        searchCustomerPage.setCustomerId("4a537241-42dd-4cf9-ba9b-c9ccd03696c1");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
         wait.until(ExpectedConditions.elementToBeClickable(searchCustomerPage.getSearchButton())));
        searchCustomerPage.clickSearchButton();

        softAssertions.assertThat(searchCustomerPage.isResultsTableDisplayed())
                .as("Result table should be displayed")
                .isTrue();

    }

    @Test
    public void testSearchByFirstName(){

        searchCustomerPage.setFirstName("First");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                wait.until(ExpectedConditions.elementToBeClickable(searchCustomerPage.getSearchButton())));
        searchCustomerPage.clickSearchButton();
        String actualResult=searchCustomerPage.getNameFieldMessage();

        softAssertions.assertThat(actualResult)
                .as("Expected message should indicate that both names must be filled together.")
                .contains("Both First Name and Last Name must be filled together.");

        softAssertions.assertThat(searchCustomerPage.isResultsTableDisplayed())
                .as("Results table should not be displayed when only First Name is filled.")
                .isFalse();
    }

    @Test
    public void testSearchByLastName(){

        searchCustomerPage.setLastName("Last");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                wait.until(ExpectedConditions.elementToBeClickable(searchCustomerPage.getSearchButton())));
        searchCustomerPage.clickSearchButton();
        String actualResult=searchCustomerPage.getNameFieldMessage();

        softAssertions.assertThat(actualResult)
                .as("Expected message should indicate that both names must be filled together.")
                .contains("Both First Name and Last Name must be filled together.");

        softAssertions.assertThat(searchCustomerPage.isResultsTableDisplayed())
                .as("Results table should not be displayed when only Last Name is filled.")
                .isFalse();
    }

    @Test
    public void testClearButton(){

        searchCustomerPage.setCustomerId("4a537241-42dd-4cf9-ba9b-c9ccd03696c1");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
                wait.until(ExpectedConditions.elementToBeClickable(searchCustomerPage.getSearchButton())));

        searchCustomerPage.clickClearButton();

        Assert.assertEquals("", searchCustomerPage.getIdNumber());
        Assert.assertEquals("", searchCustomerPage.getCustomerId());
        Assert.assertEquals("", searchCustomerPage.getAccountNumber());
        Assert.assertEquals("", searchCustomerPage.getGsmNumber());
        Assert.assertEquals("", searchCustomerPage.getFirstName());
        Assert.assertEquals("", searchCustomerPage.getLastName());

    }

    @Test
    public void testSearchByGsmNumber(){

        searchCustomerPage.setGsmNumber("5551234567");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                wait.until(ExpectedConditions.elementToBeClickable(searchCustomerPage.getSearchButton())));

        searchCustomerPage.clickSearchButton();

        softAssertions.assertThat(searchCustomerPage.isResultsTableDisplayed())
                .as("Result table should be displayed")
                .isTrue();

    }

    @Test
    public void testSearchWithEmptyFields() {

        searchCustomerPage.setIdNumber("");
        searchCustomerPage.setCustomerId("");
        searchCustomerPage.setAccountNumber("");
        searchCustomerPage.setGsmNumber("");
        searchCustomerPage.setFirstName("");
        searchCustomerPage.setLastName("");


        WebElement searchButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchCustomerPage.getSearchButton()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchButtonElement);


        softAssertions.assertThat(searchButtonElement.isEnabled())
                .as("Search button should be inactive when fields are empty.")
                .isFalse();
    }

    @Test
    public void testCreateCustomerButtonNavigatesToCreateCustomerPage() {

        searchCustomerPage.setFirstName("Test"); // İlk ad
        searchCustomerPage.setLastName("User");  // Soyad

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                wait.until(ExpectedConditions.elementToBeClickable(searchCustomerPage.getSearchButton())));

        searchCustomerPage.clickSearchButton();

        // Create Customer butonuna tıklayın
        CreateCustomerPage createCustomerPage = searchCustomerPage.clickCreateCustomerButton();

        // Müşteri oluşturma sayfasının yüklendiğini kontrol et
        softAssertions.assertThat(createCustomerPage)
                .as("Should navigate to Create Customer page")
                .isNotNull();

        // Sayfanın başlığını kontrol et ya da başka bir özellik
        String expectedTitle = "Create Customer"; // Beklenen sayfa başlığını burada güncelleyin
        softAssertions.assertThat(createCustomerPage.getCreateCustomerTitle()) // getPageTitle() metodunu CreateCustomerPage'de oluşturduğunuzdan emin olun
                .as("Page title should be 'Create Customer'")
                .isEqualTo(expectedTitle);

        // Soft assertions'ı kontrol et
        softAssertions.assertAll();
    }


}




