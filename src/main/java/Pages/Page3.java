package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Page3 extends PageBase {
    public Page3(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "3")
    WebElement thirdPageButton;

    @FindBy(className = "b_algo")
    public List<WebElement> links2;

    public void navigateToPage3(){

        click(thirdPageButton);


    }

    public void countNumberOfLinks() {

        System.out.println("Number of links found are: "+links2.size());

//                int sum=0;
//        for(WebElement link:links){
//            sum++;
//        }
//        System.out.println("Number Of links found ="+sum);

    }

    }




