package lt.techin.evelina.test;

import lt.techin.evelina.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class LoginPageTest extends BasePageTest{

    @Test
    void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithInputs();
        Assertions.assertEquals("OrangeHRM", driver.getTitle());
    }
}
