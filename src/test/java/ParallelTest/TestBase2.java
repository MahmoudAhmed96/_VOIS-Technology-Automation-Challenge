package ParallelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase2 {


    protected ThreadLocal<RemoteWebDriver> driver=null;

    @BeforeClass
    @Parameters({"browser","url"})
    public void setup(@Optional("chrome") String browser,@Optional("https://www.bing.com/")String url) throws MalformedURLException {


        driver=new ThreadLocal<>();
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("browserName",browser);
        driver.set(new RemoteWebDriver(new URL("http://192.168.1.9:4444"),caps));
        getDriver().navigate().to(url);
    }
    public WebDriver getDriver(){

        return driver.get();
    }
    @AfterClass
    public void stopDriver(){

        getDriver().quit();
        driver.remove();

    }
}
