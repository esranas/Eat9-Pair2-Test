package Login;

import base.BaseTests;
import org.junit.Assert;
import org.junit.Test;

public class LoginTests extends BaseTests {

    @Test
    public void testLoginWithValidCredentials() {
        loginPage.setUsername("firstName.lastName@etiya.com");
        loginPage.setPassword("Abc12345");
        loginPage.clickLoginButton();
    }

}
