package lt.techin.evelina;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "select#page-menu")
    WebElement pageSizeSelect;
    @FindBy(css = "select#page-menu > option[value='20']")
    WebElement pageSize20;
    @FindBy(css = "thead [role='columnheader']:nth-of-type(1) span:nth-of-type(1)")
    WebElement sortButton;
    @FindBy(xpath = "/html//input[@id='search-field']")
    WebElement searchInput;


    public void selectPageSize() {
        pageSizeSelect.click();
        pageSize20.click();
    }
    public ArrayList<String> getProductNames() {
    List<WebElement> products = driver.findElements(By.xpath("//table//tbody//tr/td[1]"));
    ArrayList<String> productsList = new ArrayList<>(products.stream().map(WebElement::getText).collect(Collectors.toList()));
    return productsList;
    }
    public int listSize() {
        List<WebElement> products = driver.findElements(By.xpath("//table//tbody//tr/td[1]"));
         return products.size();
    }
    public void sortProducts() {
        sortButton.click();
    }
    public void searchForProduct(String searchingFor){
        searchInput.sendKeys(searchingFor);
    }
}
