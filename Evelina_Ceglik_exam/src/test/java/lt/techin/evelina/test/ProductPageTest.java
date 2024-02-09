package lt.techin.evelina.test;

import lt.techin.evelina.BasePage;
import lt.techin.evelina.MainPage;
import lt.techin.evelina.ProductPage;
import lt.techin.evelina.QaPage;
import lt.techin.evelina.test.utils.RandomNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ProductPageTest extends BasePageTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/Product.csv", numLinesToSkip = 1)
    void testAddingItemToCart(String productNameCsv){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonQa();
        QaPage qaPage = new QaPage(driver);
        qaPage.openRequiredItem(productNameCsv);

        int quantityNumber = RandomNumber.getRandomNumberForQuantity();
        ProductPage productPage =new ProductPage(driver);
        productPage.enterNumberIntoInputQuantity(quantityNumber);
        productPage.clickButtonAddToCart();
        String actualAlertMessage = productPage.getTextOfAlertMessage();
        Assertions.assertEquals("Success: You have added " +productNameCsv + " to your shopping cart!", actualAlertMessage, "Alert message content is not the same." );
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/Product.csv", numLinesToSkip = 1)
    void testShoppingCartContent(String productNameCsv){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonQa();
        QaPage qaPage = new QaPage(driver);
        qaPage.openRequiredItem(productNameCsv);

        int quantityNumber = RandomNumber.getRandomNumberForQuantity();
        ProductPage productPage =new ProductPage(driver);
        productPage.enterNumberIntoInputQuantity(quantityNumber);
        productPage.clickButtonAddToCart();
        productPage.clickToCloseTheAlert();
        productPage.clickButtonShoppingCart();
        Assertions.assertEquals(productNameCsv,productPage.getItemNameInCart(), "Item's name in the cart is the same as wanted product.");
        double expectedSumOfItemPrices = productPage.getQuantityInCart()*(productPage.getProductPrice());
        double  actualSumOfItemsPrices = productPage.getCartPrice();
        Assertions.assertEquals(expectedSumOfItemPrices, actualSumOfItemsPrices,0.01, "Shopping cart price is different from expected.");
        Assertions.assertEquals(quantityNumber, productPage.getQuantityInCart());
    }

}
