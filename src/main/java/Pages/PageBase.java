package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    JavascriptExecutor js;
    Actions actions;

    public PageBase(WebDriver driver){

        PageFactory.initElements(driver,this);

    }

    public void click(WebElement button){

        button.click();
    }

    public void sendText(WebElement searchBar,String value){

        searchBar.sendKeys(value);
    }
    public void scroll(WebDriver driver){

         js=(JavascriptExecutor) driver;
         js.executeScript("scrollBy(0,3800)");
    }

    public void MoveToElement(WebDriver driver){

        actions=new Actions(driver);
        actions.moveToLocation(500,500).perform();
    }

    public void submitSearch(WebElement element){

        element.submit();
    }

    public void iamImplicitWait(WebDriver driver){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
