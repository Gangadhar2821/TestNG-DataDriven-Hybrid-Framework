package cogmentoCRM.Web.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsManager {
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static ExtentReports getExtentReports() {
		if (extent == null) {
			String reportFolder = System.getProperty("user.dir") + "./reports/";
			new File(reportFolder).mkdirs();
			String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss").format(new Date());
			String reportPath = reportFolder + "ExtentReport_" + timestamp + ".html";

			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}

	public static ExtentTest createTest(String testName) {
		ExtentTest extentTest = getExtentReports().createTest(testName);
		test.set(extentTest);
		return extentTest;
	}

	public static ExtentTest getTest() {
		return test.get();
	}

	public static void flushReport() {
		if (extent != null) {
			extent.flush();
		}
	}
}
