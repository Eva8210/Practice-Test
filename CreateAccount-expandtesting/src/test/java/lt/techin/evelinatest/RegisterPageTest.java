package lt.techin.evelinatest;

import lt.techin.evelina.MainPage;
import lt.techin.evelina.RegisterPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegisterPageTest extends MainPageTest{


    @Test
    void validRegistration() {
        goToRegisterPage();
        RegisterPage registerPage = new RegisterPage(driver);
        String email = registerPage.randomEmailGenerator();

        String name = "jonas";
        String password = "jonasjonas";
        registerPage.enterEmailAddress(email);
        registerPage.enterName(name);
        registerPage.enterPassword(password);
        registerPage.enterPasswordForConfirmation(password);
        registerPage.clickRegisterButton();

        String actualAlertMessage = registerPage.getAlertMessage();
        String expectedAlertMessage = "User account created successfully";
        Assertions.assertEquals(expectedAlertMessage,actualAlertMessage);
    }

    @Test
    void invalidRegistration() {
        RegisterPage invalidregisterPage = new RegisterPage(driver);

        goToRegisterPage();
        String invalidEmail  = "jonas.jonaitis.com";
        String validName = "1111";
        String validPassword = "111111";
        String validPasswordRepeated = "111111";

        invalidregisterPage.registerToPage(invalidEmail,validName, validPassword, validPasswordRepeated);

        String actualAlertForInvalidEmail = invalidregisterPage.getAlertForInvalidEmail();
        String expectedAlertForInvalidEmail = "Email address is invalid";
        Assertions.assertEquals(expectedAlertForInvalidEmail, actualAlertForInvalidEmail);

    }
}
