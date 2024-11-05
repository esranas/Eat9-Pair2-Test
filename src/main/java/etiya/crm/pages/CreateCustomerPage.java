package etiya.crm.pages;

import org.openqa.selenium.By;

public class CreateCustomerPage extends BasePage{
    private By createCustomerTitle= By.xpath("/html/body/app-root/app-createcustomer/body/div[1]/div[1]/h3");

    public String getCreateCustomerTitle() {
        return find(createCustomerTitle).getText();
    }

}
