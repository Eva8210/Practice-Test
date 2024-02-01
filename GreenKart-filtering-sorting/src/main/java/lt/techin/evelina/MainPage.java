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
//    public void productsListed() {
//        List<WebElement> products = driver.findElements(By.xpath("//table//tbody//tr/td[1]"));
//        ArrayList<String> productsList = new ArrayList<>(products.stream().map(WebElement::getText).collect(Collectors.toList()));

        // example how to create a new list without stream

//        ArrayList<String> productsList = new ArrayList<>();
//        for(WebElement product: products) {
//            productsList.add(product.getText());
//            System.out.println(product.getText());
//        }
//    }
    public int listSize() {
        List<WebElement> products = driver.findElements(By.xpath("//table//tbody//tr/td[1]"));
         return products.size();
    }
    public void sortProducts() {
        sortButton.click();
//        List<WebElement> products = driver.findElements(By.xpath("//table//tbody//tr/td[1]"));
//        ArrayList<String> originalList = new ArrayList<>();
//        ArrayList<String> temporaryList = new ArrayList<>();
//        for(WebElement product: products) {
//            originalList.add(product.getText());
//            temporaryList.add(product.getText());
//        }
//        Collections.sort(temporaryList);
//
//        System.out.println(originalList);
//        System.out.println(temporaryList);
//
//        if (originalList.equals(temporaryList)) {
//            System.out.println("sorted");
//        } else {
//            System.out.println("Not sorted");
//
//        }
    }
    public ArrayList<String> getProductNames() {
        List<WebElement> products = driver.findElements(By.xpath("//table//tbody//tr/td[1]"));
        ArrayList<String> productsList = new ArrayList<>(products.stream().map(WebElement::getText).collect(Collectors.toList()));
        return productsList;
    }

    public void searchForProduct(String searchingFor){
        searchInput.sendKeys(searchingFor);
    }
}
