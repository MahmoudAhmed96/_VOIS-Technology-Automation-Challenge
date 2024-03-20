package Tests;

import Pages.Page1;
import Pages.Page2;
import Pages.Page3;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class TestPages extends TestBase {


    Page1 p1;
    Page2 p2;
    Page3 p3;

    String value;
    String value2;
    String value3;
    String value4;


@BeforeMethod
public void loadDataFromCsv() throws IOException, CsvValidationException {
    String csvPath = System.getProperty("user.dir") + "/src/test/java/Data/TestData.csv";
    CSVReader reader = new CSVReader(new FileReader(csvPath));
    String[] csvCell;
    while ((csvCell = reader.readNext()) != null) {
        value = csvCell[0];
        value2 = csvCell[1];
        value3=csvCell[2];
        value4=csvCell[3];
    }
    reader.close();
}


    @Test(priority = 0)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Search Content Test Case")
    public void User_Can_Search() throws  CsvValidationException, IOException {
        p1=new Page1(driver);
        p1.searchFeature(value);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(value));
        Assert.assertEquals(driver.getTitle(),value2);

    }

    @Test(dependsOnMethods = {"User_Can_Search"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Scroll at Page1 Test Case")
    public void user_Can_Scroll_Down_At_Page1(){

        p1=new Page1(driver);
        p2=new Page2(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        p1.scrollDown(driver);

    }

    @Test(dependsOnMethods = {"user_Can_Scroll_Down_At_Page1"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigation To Page2 Test Case")
    public void user_Can_Navigate_To_Page2(){

        p2=new Page2(driver);

        p2.navigateToPage2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(p2.secondPageButton.getText(),(value4));

        p2.CountNumberOfLinks();
        Assert.assertEquals(p2.links.size(),Integer.valueOf(value3));
        p2.scrollDown(driver);



    }
    @Test(dependsOnMethods = {"user_Can_Navigate_To_Page2"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigation To Page3 Test Case")
    public void user_Can_Navigate_To_Page3(){

        p2=new Page2(driver);
        Assert.assertEquals(p2.links.size(),Integer.valueOf(value3));
        p3=new Page3(driver);

        p3.navigateToPage3();
        p3.countNumberOfLinks();
        Assert.assertEquals(p3.links2.size(),Integer.valueOf(value3));
        Assert.assertEquals(p3.links2.size(),p2.links.size());




    }

}
