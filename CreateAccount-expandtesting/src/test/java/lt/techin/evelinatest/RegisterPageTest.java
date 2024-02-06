package lt.techin.evelinatest;

import lt.techin.evelina.BasePage;
import lt.techin.evelina.MainPage;
import lt.techin.evelina.RegisterPage;
import lt.techin.evelinatest.utils.RandomEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegisterPageTest extends BasePageTest {

     public String email = RandomEmail.getRandomEmail();
    @Test
    void validRegistration() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCreateAnAccount();
        RegisterPage registerPage = new RegisterPage(driver);
//        String email = registerPage.randomEmailGenerator();

//        String email = RandomEmail.getRandomEmail();
        System.out.println(email);
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
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCreateAnAccount();
        RegisterPage invalidregisterPage = new RegisterPage(driver);

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
