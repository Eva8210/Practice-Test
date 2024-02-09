package lt.techin.evelina.test;

import lt.techin.evelina.MainPage;
import lt.techin.evelina.QaPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QaPageTest extends BasePageTest{

    @Test
    void testItemsListing(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonQa();
        QaPage qaPage = new QaPage(driver);
        qaPage.clickButtonShowItemsAsList();
        qaPage.isActiveButtonShowItemsAsList();
        Assertions.assertTrue(qaPage.isActiveButtonShowItemsAsList(), "Items are not shown as a list");
    }
    @Test
    void testIfItemsAreInTheList(){

    }
}

