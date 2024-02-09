package lt.techin.evelina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QaPage extends BasePage{
    public QaPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button#button-list")
    WebElement buttonShowItemsAsList;
    @FindBy(xpath = "//div[@id='product-list']//div[@class='product-thumb']")
    List<WebElement> items;
    @FindBy(xpath = "//div[@class='content']//a")
    List<WebElement> itemsNames;
    @FindBy(xpath = "//button[@id = 'button-cart']")
    WebElement buttonAddToCart;

    public void clickButtonShowItemsAsList(){
        buttonShowItemsAsList.click();
    }
    public boolean isActiveButtonShowItemsAsList() {
        return buttonShowItemsAsList.getAttribute("class").contains("active");
    }
    public ArrayList<String> putItemsIntoList() {
        ArrayList<String> itemsList = new ArrayList<>(items.stream().map(WebElement::getText).collect(Collectors.toList()));
        return itemsList;
    }
    public boolean checkIfListContainsSpecialItem(String productName){
        for (String specialName : putItemsIntoList()) {
            if (specialName.contains(productName)){
                return true;
            }
        }
        return false;
    }
    public boolean checkIfRequiredItemIsDisplayed(String productName) {
        WebElement requiredItem = driver.findElement(By.linkText(productName));
        return requiredItem.isDisplayed();
    }
    public boolean checkIfRequiredItemNameMatches(String productName) {
        ArrayList<String> itemsNamesList = new ArrayList<>(itemsNames.stream().map(WebElement::getText).collect(Collectors.toList()));
        for (String specialName : itemsNamesList) {
            if (specialName.equals(productName)) {
                return true;
            }
        }
        return false;
    }
    public void openRequiredItem(String productName) {
        WebElement requiredItem = driver.findElement(By.linkText(productName));
        requiredItem.click();
    }
    public boolean isDisplayedButtonAddToCart() {
        return buttonAddToCart.isDisplayed();
    }
}
