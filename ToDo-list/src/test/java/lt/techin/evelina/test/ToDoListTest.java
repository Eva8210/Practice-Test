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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToDoListTest extends BasePageTest {


//WebElement inputTodo;


    @Test
    void addNewTodo() {
        WebElement inputTodo = driver.findElement(By.xpath("//*[@id=\"container\"]/input"));
        inputTodo.sendKeys("Get a job", Keys.ENTER);
        WebElement lastInput = driver.findElement(By.cssSelector("#container > ul > li:last-child"));
        lastInput.getText();
        System.out.println(lastInput.getText());
        Assertions.assertEquals("Get a job",lastInput.getText());
        lastInput.click();
        inputTodo.getAttribute("completed");

    }

}
