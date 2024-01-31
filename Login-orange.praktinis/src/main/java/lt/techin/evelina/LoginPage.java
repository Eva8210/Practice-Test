package lt.techin.evelina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[contains(@class, 'orangehrm-demo-credentials')]/p[1]")
    WebElement givenUsername;
    @FindBy(xpath = "//div[contains(@class, 'orangehrm-demo-credentials')]/p[2]")
    WebElement givenPassword;
    @FindBy(xpath = "//form//input[contains(@name, 'username')]")
    WebElement usernameInput;
    @FindBy (xpath = "//form//input[contains(@name, 'password')]")
    WebElement passwordInput;
    @FindBy(xpath = "//form//button[contains( ., 'Login')]")
    WebElement loginButton;
    @FindBy(css = ".oxd-userdropdown > .oxd-userdropdown-tab")
    WebElement dropdownAcc;
    @FindBy(css = "[role] li:nth-of-type(4) .oxd-userdropdown-link")
    WebElement logoutButton;
    @FindBy(css = ".orangehrm-login-title")
    WebElement loginLogo;
    @FindBy(css =".oxd-alert-content--error")
    WebElement errorMessage;

    public String getUserName() {
        return givenUsername.getText().split(" : ")[1].trim();
    }
    public String getPassword() {
        String fullPassword = givenPassword.getText();
        String[] passwordWords = fullPassword.split(" : ");
        return passwordWords[passwordWords.length-1];
    }
    public void loginWithInputs(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    public void successfulLogin() {
        dropdownAcc.click();
    }
    public void logout() {
        logoutButton.click();
    }
    public void successfulLogout() {
        loginLogo.click();
    }
    public String alertAppears() {
        return errorMessage.getText();
    }
}
