package lt.techin.evelina.test;

import lt.techin.evelina.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainPageTest extends BasePageTest{

    @Test
    void addItemToTheList() {
        MainPage mainPage = new MainPage(driver);

        String newItem = "bread";
        int newCalories = 600;
        mainPage.addNewItem(newItem);
        mainPage.addNewCalories(newCalories);
        mainPage.clickButtonAddMeal();

        mainPage.enterMealAndAddToList("Egg", 50);
        mainPage.enterMealAndAddToList("Yogurt", 87);
        mainPage.enterMealAndAddToList("Pancakes", 369);
        mainPage.enterMealAndAddToList("Bacon", 200);
        mainPage.enterMealAndAddToList("Coffee", 47);
        System.out.println(mainPage.createMealsList());
    }
    @Test
    void CalculateMealsCalories() {
        MainPage mainPage = new MainPage(driver);

        mainPage.enterMealAndAddToList("Egg", 50);
        mainPage.enterMealAndAddToList("Yogurt", 87);
        mainPage.enterMealAndAddToList("Pancakes", 369);
        mainPage.enterMealAndAddToList("Bacon", 200);
        mainPage.enterMealAndAddToList("Coffee", 47);

        int expectedCalories = mainPage.caloriesCalculator();
        int actualCalories = mainPage.printTotalCaloriesInPage();
        Assertions.assertEquals(expectedCalories,actualCalories);
    }

    @Test
    void editItemsCalories() {
        MainPage mainPage = new MainPage(driver);
        mainPage.enterMealAndAddToList("Egg", 50);
        mainPage.enterMealAndAddToList("Yogurt", 87);
        mainPage.enterMealAndAddToList("Pancakes", 369);
        mainPage.enterMealAndAddToList("Bacon", 200);
        mainPage.enterMealAndAddToList("Coffee", 47);
        mainPage.clickEditButton();
        mainPage.clearAddCaloriesInput();

        int editedCalories = 120;
        mainPage.addNewCalories(editedCalories);
        mainPage.clickUpdateButton();


    }
}
