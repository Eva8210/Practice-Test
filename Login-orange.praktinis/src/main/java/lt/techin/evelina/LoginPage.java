package lt.techin.evelina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[1]")
//    @FindBy(xpath = "//*[@id=\"app\"]/*div/p[contains(@text(),'Username :']")
    WebElement givenUsername;
    String name = givenUsername.getText();
    String[] usernameWords = name.split(" : ");
    String username =  usernameWords[usernameWords.length-1];

//    public String getRealUsername(WebElement givenUsername) {
//        String name = givenUsername.getText();
//        String[] usernameWords = name.split(" : ");
//        String username =  usernameWords[usernameWords.length-1];
//        return username;
//    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[2]")
    WebElement givenPassword;

    String fullPassword = givenPassword.getText();
    String[] passwordWords = fullPassword.split(" : ");
    String  password = passwordWords[passwordWords.length-1];

      @FindBy(xpath = "//input[contains(@name, 'username')]")
      WebElement usernameInput;

      @FindBy (xpath = "//input[contains(@name, 'password')]")
      WebElement passwordInput;

    @FindBy(xpath = "//button[contains( ., 'Login')]")
    WebElement loginButton;

    public void loginWithInputs() {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

//    public String getLastWord (WebElement username) {
//        String[] lastWord = username.toString().split(" : ");
//        return lastWord[lastWord.length-1];
//    }

}
