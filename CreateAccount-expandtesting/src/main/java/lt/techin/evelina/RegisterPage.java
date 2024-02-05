package lt.techin.evelina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class RegisterPage extends MainPage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html//input[@id='email']")
    WebElement emailInput;
    @FindBy(xpath = "/html//input[@id='name']")
    WebElement nameInput;
    @FindBy(xpath = "/html//input[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "/html//input[@id='confirmPassword']")
    WebElement confirmPasswordInput;
    @FindBy(xpath = "/html//div[@id='root']//form//button[@type='submit']")
    WebElement registerButton;
    @FindBy(xpath = "//*[@id=\"root\"]//div[@class='alert alert-success']/b")
    WebElement alertOfSuccessfulRegistration;
    @FindBy(xpath = "//div[contains(text(),\"Email address is invalid\")]")
    WebElement alertOfInvalidEmail;
    @FindBy(xpath = "//div[contains(text(),\"User name should be between 4 and 30 characters\")]")
    WebElement alertOfInvalidName;
    @FindBy(xpath = "//div[contains(text(),\"Password should be between 6 and 30 characters\")]")
    WebElement alertOfInvalidPassword;

    public void enterEmailAddress(String email) {
        emailInput.sendKeys(email);
    }
    public void enterName(String name) {
        nameInput.sendKeys(name);
    }
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void enterPasswordForConfirmation(String password) {
        confirmPasswordInput.sendKeys(password);
    }
    public void clickRegisterButton(){
        registerButton.click();
    }

    public void registerToPage( String email, String name, String password, String passwordSecond) {
        enterEmailAddress(email);
        enterName(name);
        enterPassword(password);
        enterPasswordForConfirmation(passwordSecond);
        clickRegisterButton();
    }
    public String getAlertMessage(){
        return alertOfSuccessfulRegistration.getText();
    }
    public String randomEmailGenerator(){
        emailInput.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return ("username" + randomInt + "@gmail.com");
    }
    public String getAlertForInvalidEmail() {
        return alertOfInvalidEmail.getText();
    }
    public String getAlertForInvalidName() {
        return alertOfInvalidName.getText();
    }
    public String getAlertForInvalidPassword() {
        return alertOfInvalidPassword.getText();
    }
}
