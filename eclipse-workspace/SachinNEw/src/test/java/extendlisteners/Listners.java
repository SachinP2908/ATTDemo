package extendlisteners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testclasses.BaseTest;
import utility.ScreenShot;

public class Listners extends BaseTest implements ITestListener {
	ExtentReports extent = ExtendReportGen.extentReportGenerator();
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On test start:" + result.getName());
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On test success:" + result.getName());
		test.log(Status.PASS, "test case is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On test fail:" + result.getName());
		test.fail(result.getThrowable());
		try {
			test.addScreenCaptureFromPath(ScreenShot.captureScreenshotWithReturnPath(driver, result.getName()));
		} catch (IOException e) {
			System.out.println("name of ss is " + result.getName());
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On test skipped:" + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On  start:" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On finish:" + context.getName());
		extent.flush();
	}

}
