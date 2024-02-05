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
        for (WebElement product : products) {
            sortedList.add(product.getText());
        }
        Collections.sort(sortedList);
        Assertions.assertEquals(sortedList, mainPage.getProductNames());
    }
    @Test
    void searchForProduct() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectPageSize();
        String searchedWord = "an";

        List<String> unfilteredProductList = mainPage.getProductNames();

        mainPage.searchForProduct(searchedWord);
        List<String> expectedSearchResultList = unfilteredProductList.stream().filter(pro->pro.contains(searchedWord)).toList();
        List<String> actualSearchResultList = mainPage.getProductNames();
        Assertions.assertEquals(expectedSearchResultList,actualSearchResultList);
    }
}
