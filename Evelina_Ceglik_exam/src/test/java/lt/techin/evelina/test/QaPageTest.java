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
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonQa();
        QaPage qaPage = new QaPage(driver);
        qaPage.clickButtonShowItemsAsList();
        qaPage.putItemsIntoList();
        System.out.println(qaPage.putItemsIntoList());
        String productName = "Code Confusion Raccoon";
        Assertions.assertTrue(qaPage.checkIfListContainsSpecialItem(productName), productName + " does not exist in the shop");

        qaPage.checkIfRequiredItemIsDisplayed(productName);
        System.out.println(qaPage.checkIfRequiredItemIsDisplayed(productName));
        Assertions.assertTrue(qaPage.checkIfRequiredItemIsDisplayed(productName), "Given product is not displayed");

        System.out.println(qaPage.checkIfRequiredItemNameMatches(productName));
        Assertions.assertTrue(qaPage.checkIfRequiredItemNameMatches(productName), "Item name does not match");
    }
}

