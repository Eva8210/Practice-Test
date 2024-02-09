package lt.techin.evelina;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#input-quantity")
    WebElement inputQuantity;
    @FindBy(xpath = "//button[@id = 'button-cart']")
    WebElement buttonAddToCart;
    @FindBy(xpath = "//div[@id='alert']")
    WebElement alert;
    @FindBy(xpath="//div[@id='alert']//button[@class='btn-close']")
    WebElement buttonToCloseAlert;
    @FindBy(xpath = "//button[contains(@class, 'dropdown-toggle')]")
    WebElement buttonShoppingCart;
    @FindBy(xpath = "//td[@class ='text-start']")
    WebElement itemNameInCart;
    @FindBy(xpath = "//td[@class='text-end'][1]")
    WebElement quantityOfItemInCart;
    @FindBy(xpath = "//span[@class='price-new']")
    WebElement productPrice;
    @FindBy(xpath = "//td[@class='text-end'][2]")
    WebElement priceOfItemsInCart;

    public void enterNumberIntoInputQuantity(int quantityNumber) {
        inputQuantity.clear();
        String number = Integer.toString(quantityNumber);
        inputQuantity.sendKeys(number);
    }
    public void clickButtonAddToCart() {
        buttonAddToCart.click();
    }
    public String getTextOfAlertMessage(){
        return alert.getText();
    }
    public void clickToCloseTheAlert(){
        buttonToCloseAlert.click();
    }
    public void clickButtonShoppingCart(){
        buttonShoppingCart.click();
    }
    public String getItemNameInCart() {
        return itemNameInCart.getText();
    }
    public int getQuantityInCart(){
       String numberWithX = quantityOfItemInCart.getText();
       String quantityNumber = numberWithX.split(" ")[1];
        return Integer.parseInt(quantityNumber);
    }
    public double getProductPrice() {
        String productPriceWithCurrency = productPrice.getText();
        String priceNumber = productPriceWithCurrency.split("\\$")[1];
        return Double.parseDouble(priceNumber);
    }
    public double getCartPrice() {
        String productPriceWithCurrency = priceOfItemsInCart.getText();
        String priceNumber = productPriceWithCurrency.split("\\$")[1];
        return Double.parseDouble(priceNumber);
    }
}
