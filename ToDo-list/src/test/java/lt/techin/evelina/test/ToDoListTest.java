package lt.techin.evelina.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ToDoListTest extends BasePageTest {


//WebElement inputTodo;


    @Test
    void addNewTodo() {
        WebElement inputTodo = driver.findElement(By.xpath("//*[@id=\"container\"]/input"));
        inputTodo.sendKeys("Get a job", Keys.ENTER);
        WebElement lastInput = driver.findElement(By.cssSelector("#container > ul > li:last-child"));
        lastInput.getText();
        Assertions.assertEquals("Get a job",lastInput.getText());
        lastInput.click();
        Assertions.assertEquals("completed",lastInput.getAttribute("class" ));

        List<WebElement> listOfItems = driver.findElements(By.cssSelector("#container > ul >li"));
        for (int i = 0; i < listOfItems.size()-1; i++) {
            if(!listOfItems.get(i).getAttribute("class").equals("completed")) {
                System.out.println("pass");;
            } else {
                System.out.println("fail");

            }

        }


    }
    @Test
    void deleteInput() throws InterruptedException {
//        List<WebElement> listOfItemsBefore = driver.findElements(By.cssSelector("#container > ul >li"));
//        int listSizeBefore = (listOfItemsBefore.size()-1);
        WebElement unwantedInput = driver.findElement(By.cssSelector("#container > ul > li:last-child"));
        String textofDeletedElement = unwantedInput.getText();
        System.out.println(unwantedInput.getText());
        Actions action = new Actions(driver);
        action.moveToElement(unwantedInput).perform();
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[3]/span/i"));
        //*[@id="container"]/ul/li[3]/span/i
        //li:last-child/i[contains(text(),'fa-trash')]
        action.click(deleteButton).perform();
        Thread.sleep(2000);
        WebElement lastInput = driver.findElement(By.cssSelector("#container > ul > li:last-child"));
        System.out.println(lastInput.getText());
        String textOfLastItem = lastInput.getText();
//        List<WebElement> listOfItemsAfter = driver.findElements(By.cssSelector("#container > ul >li"));
//        int listSizeAfter = listOfItemsAfter.size();
//        Assertions.assertEquals(listSizeBefore,listSizeAfter);
        Assertions.assertNotEquals(textofDeletedElement,textOfLastItem);


    }

}
