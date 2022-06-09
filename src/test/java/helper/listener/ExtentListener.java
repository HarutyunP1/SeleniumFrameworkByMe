package helper.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import helper.logger.LoggerHelper;
import helper.resource.ResourceHelper;
import org.apache.log4j.Logger;
import org.testng.*;
import testScripts.TestBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class ExtentListener extends TestBase implements ITestListener, IClassListener, ISuiteListener {
    private Logger log = LoggerHelper.getLogger(ExtentListener.class);
    ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onBeforeClass(ITestClass testClass) {
        htmlReporter=new ExtentSparkReporter(ResourceHelper.getResourcePath("test-output/reports/") + "ExtentReportResults.html");
        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        log.info("I am in on BeforeClass method " + testClass.getName());
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("report");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        htmlReporter.config().setTheme(Theme.DARK);

    }

    @Override
    public void onAfterClass(ITestClass testClass) {
        log.info("I am in onAfterClass method " + testClass.getName());
        extent.flush();


    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("I am in onStart method " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test=extent.createTest(iTestResult.getMethod().getMethodName());
        try {
            test.addScreenCaptureFromBase64String(new GetScreenShot(TestBase.getDriver()).getBase64Screenshot());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(iTestResult.getMethod().getMethodName() + ("I am in onTestStart method "));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS, "test is success " + iTestResult.getMethod().getMethodName());
        log.info(iTestResult.getMethod().getMethodName() + " test is succeed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test.log(Status.FAIL, "test is fail " + iTestResult.getMethod().getMethodName());
        log.info(iTestResult.getMethod().getMethodName() + " test is failed.");

    }




    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info(iTestResult.getMethod().getMethodName() + " test is skipped.");
    }


}
