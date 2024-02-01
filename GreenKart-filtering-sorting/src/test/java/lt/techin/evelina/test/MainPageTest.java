package lt.techin.evelina.test;

import lt.techin.evelina.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainPageTest extends BasePageTest{

    @Test
    void listProducts() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectPageSize();
        int productsCount = mainPage.listSize();
        Assertions.assertEquals(19, productsCount);
        mainPage.sortProducts();

        List<WebElement> products = driver.findElements(By.xpath("//table//tbody//tr/td[1]"));
        ArrayList<String> sortedList = new ArrayList<>();
        for(WebElement product: products) {
            sortedList.add(product.getText());
        }
        Collections.sort(sortedList);
        Assertions.assertEquals(sortedList,mainPage.getProductNames());

        String searchedWord = "ba";
        mainPage.searchForProduct(searchedWord);


//        ArrayList<String> searchResults = new ArrayList<>(products.stream()
//                .filter(products.contains(searchedword)));
//        if (products.contains(searchedword)) {
//            for(WebElement product: products) {
//                sortedList.add(product.getText());
//            }
//            searchResults.add(product.getText());
//        }
        ArrayList<String> productsList = new ArrayList<>(products.stream().map(WebElement::getText).collect(Collectors.toList()));
        ArrayList<String> searchResults = new ArrayList<>();
        for (String product: productsList) {
            if (product.contains(searchedWord)) {
                searchResults.add(product);
            }
        }
        System.out.println(searchResults);
    }
}
