package lt.techin.evelina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QaPage extends BasePage{
    public QaPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button#button-list")
    WebElement buttonShowItemsAsList;

    @FindBy(xpath = "//div[@id='product-list']//div[@class='product-thumb']")
    List<WebElement> itemsList;

    public void clickButtonShowItemsAsList(){
        buttonShowItemsAsList.click();
    }
    public boolean isActiveButtonShowItemsAsList() {
        return buttonShowItemsAsList.getAttribute("class").contains("active");
    }
    public void 
}
