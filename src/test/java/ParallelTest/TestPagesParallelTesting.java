package ParallelTest;

import Data.ValueReader;
import Pages.Page1;
import Pages.Page2;
import Pages.Page3;
import ParallelTest.TestBase2;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestPagesParallelTesting extends TestBase2 {

    Page1 p1;
    Page2 p2;
    Page3 p3;

    @DataProvider(name = "value")
    public static Object[][] userData() throws IOException {
        ValueReader er=new ValueReader();

        return er.getExcelData();
    }

    @Test(priority = 0,dataProvider = "value")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Search Content Test Case")
    public void User_Can_Search(String searchValue) throws InterruptedException {

        p1=new Page1(getDriver());
        p1.searchFeature(searchValue);
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("vodafone"));
        Assert.assertEquals(getDriver().getTitle(),"vodafone - Search");


    }
    @Test(dependsOnMethods = {"User_Can_Search"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Scroll at Page1 Test Case")
    public void user_Can_Scroll_Down_At_Page1(){

        p1=new Page1(getDriver());
        p2=new Page2(getDriver());

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        p1.scrollDown(getDriver());

    }

    @Test(dependsOnMethods = {"user_Can_Scroll_Down_At_Page1"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigation To Page2 Test Case")
    public void user_Can_Navigate_To_Page2(){

        p2=new Page2(getDriver());
        p2.navigateToPage2();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(p2.secondPageButton.getText(),"2");

        p2.CountNumberOfLinks();
        Assert.assertEquals(p2.links.size(),10);
        p2.scrollDown(getDriver());



    }
    @Test(dependsOnMethods = {"user_Can_Navigate_To_Page2"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigation To Page3 Test Case")
    public void user_Can_Navigate_To_Page3(){

        p2=new Page2(getDriver());
        Assert.assertEquals(p2.links.size(),10);
        p3=new Page3(getDriver());

        p3.navigateToPage3();
        p3.countNumberOfLinks();
        Assert.assertEquals(p3.links2.size(),10);
        Assert.assertEquals(p3.links2.size(),p2.links.size());




    }
}
