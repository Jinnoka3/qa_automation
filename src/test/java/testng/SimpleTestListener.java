package testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SimpleTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test has started running:"  + iTestResult.getMethod().getMethodName() + " at:" + iTestResult.getStartMillis());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test was success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test was failure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test was skipped!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Some error");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Passed tests: " + iTestContext.getPassedTests());
        System.out.println("Failed tests:" + iTestContext.getFailedTests());
    }
}
