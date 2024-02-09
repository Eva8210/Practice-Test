package lt.techin.evelina.test;

import lt.techin.evelina.MainPage;
import lt.techin.evelina.QaPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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
    @ParameterizedTest
    @CsvFileSource(resources = "/Product.csv", numLinesToSkip = 1)
    void testIfItemsAreInTheList(String productNameCsv){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonQa();
        QaPage qaPage = new QaPage(driver);
        qaPage.clickButtonShowItemsAsList();
        qaPage.putItemsIntoList();
        Assertions.assertTrue(qaPage.checkIfListContainsSpecialItem(productNameCsv), productNameCsv + " does not exist in the shop");
        qaPage.checkIfRequiredItemIsDisplayed(productNameCsv);
        Assertions.assertTrue(qaPage.checkIfRequiredItemIsDisplayed(productNameCsv), "Given product is not displayed");
        Assertions.assertTrue(qaPage.checkIfRequiredItemNameMatches(productNameCsv), "Item name does not match");
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/Product.csv", numLinesToSkip = 1)
    void testIfItemCanBeOpened(String productNameCsv) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonQa();
        QaPage qaPage = new QaPage(driver);
        qaPage.openRequiredItem(productNameCsv);
        Assertions.assertEquals(productNameCsv, driver.getTitle(), "Page title differs from product name");
        Assertions.assertTrue(qaPage.isDisplayedButtonAddToCart(), "Add to Cart button is not displayed");
    }
}

