package cogmentoCRM.Web.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import cogmentoCRM.Web.base.BasePage;
import cogmentoCRM.Web.base.WebDriverFactory;
import cogmentoCRM.Web.utilities.ExtentReportsManager;
import cogmentoCRM.Web.utilities.LoggerUtil;

public class CogmentoCRM_Listener implements ITestListener {
	LoggerUtil log = new LoggerUtil();

	@Override
	public void onTestStart(ITestResult result) {
		log.info("Started CogmentoCRM_Listener ...");
		ExtentReportsManager.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportsManager.getTest().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("Test Listner triggered on Test Failure");
		// Log failure status in the Extent Report
		ExtentReportsManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());

		// Capture screenshot on test failure
		try {
			String screenShotpath = new BasePage(WebDriverFactory.getDriver()).screenShotOnFailure(result);
			// Attach the screenshot to the report
			ExtentReportsManager.getTest().addScreenCaptureFromPath(screenShotpath);
		} catch (IOException e) {
			System.err.println("Error while capturing screenshot: " + e.getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReportsManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportsManager.flushReport();
	}
}
