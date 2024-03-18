package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Page2 extends PageBase {
    public Page2(WebDriver driver) {
        super(driver);
    }


    @FindBy(linkText = "2")
    public WebElement secondPageButton;

    @FindBy(className= "b_algo")
    //.b_algo.b_ccontain
    public List<WebElement> links;

    public void navigateToPage2(){
        click(secondPageButton);
    }

    public void scrollDown(WebDriver driver){

        scroll(driver);

    }

    public void CountNumberOfLinks(){
        System.out.println("Number of links Found are: "+links.size());

//        int sum=0;
//        for(WebElement link:links){
//
//            sum++;
//
//        }
//        System.out.println("Number Of links found ="+sum);

    }
}
