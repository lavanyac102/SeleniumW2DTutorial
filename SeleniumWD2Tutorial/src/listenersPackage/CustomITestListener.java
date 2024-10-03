package listenersPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomITestListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// When test method starts
		System.out.println("onTestStart = >"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// if test method is successful
		System.out.println("ontestSuccessful = >"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		// if test method is failed
		System.out.println("ontestfailure = >"+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		// when test method is skipped
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// before test start in xml file
		System.out.println("onStart = >"+context.getName());
	}

	public void onFinish(ITestContext context) {
		// not implemented
		// after test start in xml file
				System.out.println("onFinish = >"+context.getName());
	}

}
