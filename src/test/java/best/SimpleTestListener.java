package best;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static best.BaseTest.LOGGER;


public class SimpleTestListener implements ITestListener {

    //WebDriver driver;

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveAllureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Test has started running:"  + iTestResult.getMethod().getMethodName() + " at:" + iTestResult.getStartMillis());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //saveAllureScreenshot(driver);
        LOGGER.info("Test was success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            takeScreenShot(iTestResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.error("Test was failure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("Test was skipped!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.error("Some error");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info("Start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("Passed tests: " + iTestContext.getPassedTests());
        LOGGER.info("Failed tests:" + iTestContext.getFailedTests());
        LOGGER.info("End");
    }

    private void takeScreenShot(ITestResult var1) throws IOException {
        Object currentClass = var1.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        File screenshot = ((TakesScreenshot) webDriver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/target/allure-results/screenshots/" + var1.getTestClass()+ ".jpg"));
    }
}