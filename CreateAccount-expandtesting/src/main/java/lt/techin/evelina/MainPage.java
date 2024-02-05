package lt.techin.evelina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html//div[@id='root']//div[@class='col-lg-6']//a[@href='/notes/app/register']")
    WebElement createAnAccountButton;

    public void clickCreateAnAccount() {
        createAnAccountButton.click();
    }
}
