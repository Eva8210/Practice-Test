package lt.techin.evelina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='root']//a[@href='/notes/app/login']")
    WebElement loginButtonInMainPage;
    @FindBy(xpath = "/html//input[@id='email']")
    WebElement emailInput;
    @FindBy(xpath = "/html//input[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//form//button[@type='submit']")
    WebElement loginButtonInLoginPage;
    @FindBy(xpath = "//div[@id='navbarSupportedContent']/ul//a[@href='/notes/app/profile']")
    WebElement profileButton;
    @FindBy(xpath = "/html//input[@id='user-email']")
    WebElement accountEmail;
    @FindBy(xpath = "//div[@id='navbarSupportedContent']//button[@class='btn btn-outline-danger']")
    WebElement logoutButton;

    public void clickLoginButton() {
        loginButtonInMainPage.click();
    }
    public void enterEmailInput(String email){
        emailInput.sendKeys(email);
    }
    public void enterPasswordInput (String password) {
        passwordInput.sendKeys(password);
    }
    public void clickLoginButtonInLoginPage() {
        loginButtonInLoginPage.click();
    }
    public void goToYourProfile() {
        profileButton.click();
    }
    public String getAccountEmail(){
        return accountEmail.getAttribute("value");
    }
    public void clickLogoutButton() {
        logoutButton.click();
    }
}
