package lt.techin.evelina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @FindBy(xpath = "//div[@class='invalid-feedback']")
    List<WebElement> registrationErrorMessages;
    @FindBy(xpath = "//div[@class='invalid-feedback']")
    WebElement registrationEmptyMessage;

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


    public boolean isMessageDislayed(String errorMessageText){
//        ArrayList<String> newErrorMessages = new ArrayList<>();
//        for (WebElement errorMessage : registrationErrorMessages) {
//            newErrorMessages.add(errorMessage.getText());
//        }
//        return newErrorMessages.contains(errorMessageText);

        ArrayList<String> newErrorMessages = registrationErrorMessages.stream().map(WebElement::getText).collect(Collectors.toCollection(ArrayList::new));
        return newErrorMessages.contains(errorMessageText);
    }
    public boolean isRegistrationFormEmpty() {
        return registrationEmptyMessage.isDisplayed();
    }
}
