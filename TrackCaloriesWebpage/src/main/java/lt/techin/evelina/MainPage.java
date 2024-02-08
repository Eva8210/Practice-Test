package lt.techin.evelina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    @FindBy(xpath = "//span[@class='total-calories']")
    WebElement totalCaloriesCount;
    @FindBy(xpath = "//ul[@id='item-list']/li[last()]/a")
    WebElement editPencilButton;
    @FindBy(xpath = "//ul[@id='item-list']/li[last()]")
    WebElement lastListedItem;
    @FindBy(xpath = "//form//button[contains(text(), 'Update Meal')]")
    WebElement updateMealButton;
    @FindBy(xpath = "//form//button[contains(text(), 'Delete Meal')]")
    WebElement deleteMealButton;
    @FindBy(xpath = "//form//button[contains(text(), 'Back')]")
    WebElement backButton;
    @FindBy(xpath = "//li/a[contains(@class, 'clear-btn')]")
    WebElement clearAllButton;

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
    public int printTotalCaloriesInPage(){
        String totalCaloriesFromPage = totalCaloriesCount.getText();
        return Integer.parseInt(totalCaloriesFromPage);
    }
    public int caloriesCalculator() {
        List<Integer> allCalories = new ArrayList<>();
            for (WebElement meal : meals) {
                String text = meal.getText();
                String parts = text.split(" ")[1];
                int calorieValue = Integer.parseInt(parts);
                allCalories.add(calorieValue);
        }
        int totalCaloriesCalculated = 0;
        for (Integer caloriesNumber : allCalories) {
            totalCaloriesCalculated += caloriesNumber;
        }
        return totalCaloriesCalculated;
    }
    public void clickEditButton(){
        editPencilButton.click();
    }
    public void clearAddCaloriesInput(){
        addCaloriesInput.clear();
    }
    public void clickUpdateButton(){
        updateMealButton.click();
    }
    public String getLastListedText(){
        return lastListedItem.getText();
    }
    public void clickDeleteMealButton(){
        deleteMealButton.click();
    }
    public void clickGoBackButton(){
        backButton.click();
    }
    public boolean updateButtonIsDisplayed(){
        return updateMealButton.isDisplayed();
    }
    public void clickClearAllButton(){
        clearAllButton.click();
    }
    public int printMealListSize(){
        return meals.size();
    }
}