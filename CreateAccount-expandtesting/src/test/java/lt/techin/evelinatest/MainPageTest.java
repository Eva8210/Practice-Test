package lt.techin.evelinatest;

import lt.techin.evelina.MainPage;
import org.junit.jupiter.api.Test;

public class MainPageTest extends BasePageTest{

    @Test
    void goToRegisterPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCreateAnAccount();
    }
}
