package Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

    public static void captureScreenshot(WebDriver driver, String screenShotName) throws IOException {


        Path destPath= Paths.get("./Screenshots",screenShotName+".png");
        Files.createDirectories(destPath.getParent());
        FileOutputStream Out =new FileOutputStream(destPath.toString());
        Out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        Out.close();

    }
}
