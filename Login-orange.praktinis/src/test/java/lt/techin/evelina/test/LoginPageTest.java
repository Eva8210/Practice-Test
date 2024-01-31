package lt.techin.evelina.test;

import lt.techin.evelina.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BasePageTest{

    @Test
    void testLogin() {

        LoginPage loginPage = new LoginPage(driver);
        String username = loginPage.getUserName();
        String password = loginPage.getPassword();
        loginPage.loginWithInputs(username,password);
        loginPage.successfulLogin();
        loginPage.logout();
        loginPage.successfulLogout();
    }
    @Test
    void testInvalidLogin() {
        LoginPage wrongLogin =new LoginPage(driver);
        wrongLogin.loginWithInputs("aaa", "111");
        Assertions.assertEquals("Invalid credentials", wrongLogin.alertAppears());
    }
}
