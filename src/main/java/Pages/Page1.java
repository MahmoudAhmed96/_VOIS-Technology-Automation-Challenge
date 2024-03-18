package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page1 extends PageBase {

    public Page1(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "sb_form_q")
    public WebElement searchBar;

    public void searchFeature(String value){


        sendText(searchBar,value);
        submitSearch(searchBar);



    }

    public void scrollDown(WebDriver driver){

        //iamImplicitWait(driver);
        scroll(driver);

    }
}
