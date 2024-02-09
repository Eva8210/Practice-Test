package lt.techin.evelina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@href='http://192.168.88.86/en-gb/catalog/QAstuff']")
    WebElement buttonQa;


    public void clickButtonQa(){
        buttonQa.click();
    }
}
