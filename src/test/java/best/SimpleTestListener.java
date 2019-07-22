package best;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static best.BaseTest.LOGGER;


public class SimpleTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Test has started running:"  + iTestResult.getMethod().getMethodName() + " at:" + iTestResult.getStartMillis());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("Test was success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
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
}