package lt.techin.evelinatest;

import lt.techin.evelina.LoginPage;
import lt.techin.evelinatest.utils.RandomEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BasePageTest{
    @Test
    void validLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        String email = "jonas.jonaitis@gmail.com" ;
        String password = "jonasjonas";
        loginPage.enterEmailInput(email);
        loginPage.enterPasswordInput(password);
        loginPage.clickLoginButtonInLoginPage();
        loginPage.goToYourProfile();
        Assertions.assertEquals(email,loginPage.getAccountEmail());

        loginPage.clickLogoutButton();

    }
}
