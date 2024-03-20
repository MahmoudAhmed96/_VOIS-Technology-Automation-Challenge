package Tests;

import Utility.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;

public class TestBase {

    WebDriver driver;

    //Initializing Browser Using @Parameters/@Optional TestNG Annotations To Load Data From xml File
    @BeforeTest
    @Parameters(value = {"browser","url"})
    public void startDriver(@Optional("firefox") String browser ,@Optional("https://www.bing.com") String url) {

        if(browser.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if(browser.equals("edge")){
            driver = new EdgeDriver();
        }else {
            System.out.println("Please Choose a valid browser");
        }
        driver.get(url);
        driver.manage().window().maximize();

    }

    //quite browser After Test
    	@AfterTest
    	public void stopDriver() {

    		driver.quit();
    	}


        //Taking ScreenShot of Failure if occurred
    @AfterMethod
    public void ScreenshotOnFailure(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println("Failed");
            System.out.println("Taking ScreenShot....");
            Helper.captureScreenshot(driver, result.getName());

        }

    }
}
