package etiya.crm.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By usernameField = By.id("floatingEmail");
    private By passwordField = By.id("floatingPassword");
    private By loginButton = By.xpath("//button[@class='btn btn-primary']");

    public void setUsername(String username) {
        set(usernameField, username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    //Transition method
    public SearchCustomerPage clickLoginButton() {
        click(loginButton);
        return new SearchCustomerPage();
    }

    //Convenience method
    public SearchCustomerPage logIntoApplication(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

}
