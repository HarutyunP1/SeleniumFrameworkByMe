package helper.listener;

import helper.logger.LoggerHelper;
import helper.resource.ResourceHelper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetScreenShot {
    private Logger log = LoggerHelper.getLogger(ExtentListener.class);
    WebDriver driver;

    public GetScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    public String getScreenshot() throws Exception {
        log.info("get screenshot method is called");
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = (ResourceHelper.getResourcePath("test-output/ScreenShots/reports/") + System.currentTimeMillis()
                + ".jpg");
        File finalDestination = new File(destination);

        FileUtils.copyFile(source, finalDestination);

        return finalDestination.getAbsolutePath();
    }

    public String getBase64Screenshot() throws Exception {
        log.info("get base64 screenshot method is called");
        Date oDate = new Date();
        SimpleDateFormat oSDF = new SimpleDateFormat("yyyyMMddHHmmss");
        String sDate = oSDF.format(oDate);
        String encodedBase64 = null;
        FileInputStream fileInputStream = null;
        TakesScreenshot screenshot = (TakesScreenshot) this.driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = ResourceHelper.getResourcePath("test-output/ScreenShots/reports/ScreenShots") + sDate + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        try {
            fileInputStream = new FileInputStream(finalDestination);
            byte[] bytes = new byte[(int) finalDestination.length()];
            fileInputStream.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "data:image/png;base64," + encodedBase64;
    }
}
