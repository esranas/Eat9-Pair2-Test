package etiya.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class SearchCustomerPage extends BasePage {


    private By filtersHeader=By.xpath("//div[@class='filters']//h2");
    private By idNumberField=By.id("natId");
    private By customerIdField=By.id("customerId");
    private By accountNumberField=By.id("accNumber");
    private By gsmNumberField=By.id("mobilePhone");
    private By firstNameField=By.id("firstName");
    private By lastNameField=By.id("lastName");
    private By searchButton=By.xpath("//div[@class='buttons']//button[@type='submit']");
    private By clearButton=By.xpath("//div[@class='buttons']//button[@type='button']");
    private By resultsTable=By.xpath("/html/body/app-root/app-customer-search/body/form/div[1]/div[2]/table");
    private By createCustomerButton=By.xpath("/html/body/app-root/app-customer-search/body/form/div[1]/div[2]/div/button");
    private By nameFieldMessage=By.xpath("/html/body/app-root/app-customer-search/body/form/div[1]/div[1]/div[1]");


    public String getIdNumber(){
        return find(idNumberField).getText();
    }
    public void setIdNumber(String idNumber){
        set(idNumberField,idNumber);
    }

    public String getCustomerId(){
        return find(customerIdField).getText();
    }
    public void setCustomerId(String customerId){
        set(customerIdField,customerId);
    }
    public String getAccountNumber(){
        return find(accountNumberField).getText();
    }
    public void setAccountNumber(String accountNumber){
        set(accountNumberField,accountNumber);
    }

    public String getGsmNumber(){
        return find(gsmNumberField).getText();
    }
    public void setGsmNumber(String gsmNumber){
        set(gsmNumberField,gsmNumber);
    }

    public String getFirstName(){
        return find(firstNameField).getText();
    }
    public void setFirstName(String firstName){
        set(firstNameField,firstName);
    }

    public String getLastName(){
        return find(lastNameField).getText();
    }
    public void setLastName(String lastName){
        set(lastNameField,lastName);
    }

    public  void clickSearchButton() {
        click(searchButton);
    }
    public void clickClearButton() {
        click(clearButton);
    }

    public By getSearchButton() {
        return searchButton;
    }


    public String getNameFieldMessage() {
        //return wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldMessage)).getText();
    return find(nameFieldMessage).getText();
    }

    //Transition method
    public CreateCustomerPage clickCreateCustomerButton() {
        click(createCustomerButton);
        return new CreateCustomerPage();
    }


    public boolean isResultsTableDisplayed() {
        return find(resultsTable).isDisplayed();

    }

    public boolean isFiltersHeaderDisplayed() {
        return find(filtersHeader).isDisplayed();
    }





}
