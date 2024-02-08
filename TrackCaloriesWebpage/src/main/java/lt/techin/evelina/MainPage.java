package lt.techin.evelina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='item-name']")
    WebElement addItemInput;
    @FindBy(xpath = "//input[@id='item-calories']")
    WebElement addCaloriesInput;
    @FindBy(xpath = "//button[contains(text(), 'Add Meal')]")
    WebElement addMealButton;
    @FindBy(xpath = "//li[contains(@class,'collection-item')]")
    List<WebElement> meals;

    public void addNewItem(String item) {
        addItemInput.sendKeys(item);
    }
    public void addNewCalories(int calories){
        addCaloriesInput.sendKeys(String.valueOf(calories));
    }
    public void clickButtonAddMeal() {
        addMealButton.click();
    }
    public void enterMealAndAddToList(String item, int calories){
        addNewItem(item);
        addNewCalories(calories);
        clickButtonAddMeal();
    }
    public ArrayList<String> createMealsList() {
        ArrayList<String> mealsList = new ArrayList<>(meals.stream().map(WebElement::getText).collect(Collectors.toList()));
        return mealsList;
    }

    public int caloriesCalculator() {

        List<Integer> allCalories = new ArrayList<>();
        for (WebElement meal : meals) {
            String text = meal.getText();
            String[] parts = text.split(": ");
            String numericPart = parts[1].replace("Calories", "").trim();
            int calorieValue = Integer.parseInt(numericPart);
            allCalories.add(calorieValue);
        }
        return allCalories.stream().mapToInt(Integer::intValue).sum();
    }
}