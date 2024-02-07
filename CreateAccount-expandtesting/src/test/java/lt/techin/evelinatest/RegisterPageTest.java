package lt.techin.evelinatest;

import lt.techin.evelina.LoginPage;
import lt.techin.evelina.MainPage;
import lt.techin.evelina.RegisterPage;
import lt.techin.evelinatest.utils.RandomEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RegisterPageTest extends BasePageTest {


    @Test
    void validRegistration() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCreateAnAccount();

        RegisterPage registerPage = new RegisterPage(driver);

        String email = RandomEmail.getRandomEmail();
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

    @ParameterizedTest
    @CsvFileSource(resources = "/register 1.csv", numLinesToSkip = 1)
    void invalidRegistrationWithCsvFile(String emailCsv, String nameCsv, String passwordCsv, String passwordConfirmCsv, String messageErrorCsv) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCreateAnAccount();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerToPage(emailCsv,nameCsv, passwordCsv, passwordConfirmCsv);

        Assertions.assertTrue(registerPage.isMessageDislayed(messageErrorCsv), "Error message: " + messageErrorCsv);
        System.out.println("Error message: " + messageErrorCsv);
    }
    @Test
    void registerWithEmptyInputs(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCreateAnAccount();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegisterButton();

        Assertions.assertTrue(registerPage.isRegistrationFormEmpty());
    }
}
