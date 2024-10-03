package listenersPackage;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomIInvokedMethodListener implements IInvokedMethodListener{
	
	public  void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		//before every method in the test class
	    System.out.println("before invocation : " +testResult.getTestClass().getName()+ "==>"+method.getTestMethod().getMethodName());
	  }

	  public  void afterInvocation(IInvokedMethod method, ITestResult testResult) {
			//after every method in the test class
		  System.out.println("after invocation : " +testResult.getTestClass().getName()+ "==>"+method.getTestMethod().getMethodName());
	  }
	

}
