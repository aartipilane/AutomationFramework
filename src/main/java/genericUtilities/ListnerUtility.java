package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerUtility implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test script execution is started. ");

		// Create Test in Extent Report
		test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test script pass. ");

		// Log the status as PASS in extent report
		test.log(Status.PASS, methodName + "-> Test Script PASS");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test failed");
// exception
		System.out.println(result.getThrowable());

		// Log the status as FAIL in extent reports
		test.log(Status.FAIL, methodName + "-> Test Script FAIL");

		// Log the exception in extent report
		test.log(Status.WARNING, result.getThrowable());

		// Capture Screenshot

		
		JavaUtility j = new JavaUtility();
		SeleniumUtility s = new SeleniumUtility();

		String screenshotName = methodName + "-" + j.getSystemDate();

		try {

			String screenShortPath= s.captureScreenShot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(screenShortPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		System.out.println(methodName + " Test Skipped");

		System.out.println(result.getThrowable());

		// Log the status as SKIP in extent reports
		test.log(Status.SKIP, methodName + "-> Test Script SKIP");

		// Log the exception in extent report
		test.log(Status.WARNING, result.getThrowable());
	}

	public void onStart(ITestContext context) {

		System.out.println("Test Started");

		// Basic Configuration of extent report

//		ExtentSparkReporter esreport = new ExtentSparkReporter(
//				"/home/cm_geeta/AutomationTesting/Practice2024/AutomationFramework/ExtentReports"
//						+ new JavaUtility().getSystemDate() + ".html");
		
		ExtentSparkReporter esreport = new ExtentSparkReporter(
				"/home/cm_geeta/AutomationTesting/Practice2024/AutomationFramework/ExtentReports/ereport.html");
		esreport.config().setDocumentTitle("Swag Lab Execution Report");
		esreport.config().setTheme(Theme.DARK);
		esreport.config().setReportName("Automation Framework execution");

		report = new ExtentReports();
		report.attachReporter(esreport);
		report.setSystemInfo("Browser Name: ", "Chrome");

	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Finish");

		// Report Generaation Extent Report
		report.flush();
	}

}
