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

    @Test
    void invalidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        String incorrectEmail = RandomEmail.getRandomEmail();
        String password = "jonasjonas";
        loginPage.enterEmailInput(incorrectEmail);
        loginPage.enterPasswordInput(password);
        loginPage.clickLoginButtonInLoginPage();

        Assertions.assertEquals("Incorrect email address or password", loginPage.getAlertIncorrectLogin());
    }

    @Test
    void loginWithEmptyInputs(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();

        loginPage.clickLoginButtonInLoginPage();
        Assertions.assertTrue(loginPage.isLoginFormEmpty());
    }
}
