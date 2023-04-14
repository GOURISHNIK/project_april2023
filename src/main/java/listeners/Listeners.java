package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.opencart.base.BaseClass;
import com.opencart.utility.ExtentReporter;




public class Listeners extends BaseClass implements ITestListener {

	ExtentReports extentReports = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());
		extentTestThread.set(extentTest);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		WebDriver driver = null;
		
		String testName= result.getName();
		
		//extentTest.pass("passed");
				extentTestThread.get().pass(testName+" passed");
				//extentTestThread.get().log(Status.PASS,testName+" has passed");
		
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		
		String testName= result.getName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String screenShotPath = takeScreenshot(testName, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenShotPath);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
