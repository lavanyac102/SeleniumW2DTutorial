package pages.classes;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestNG_ITestResultDemo {
	
	
  @Test
  public void testMethod1() {
	  System.out.println("running testeMethod1");
	  Assert.assertTrue(false);
  }
  
  @Test
  public void testMethod2() {
	  System.out.println("running testeMethod2");
	  Assert.assertTrue(true);
  }
  @AfterMethod
  public void afterMethod(ITestResult testResult) {
	  if(testResult.getStatus()==testResult.FAILURE)
	  {
		  System.out.println("Failure " + testResult.getMethod().getMethodName());
	  }
	  if(testResult.getStatus()==testResult.SUCCESS)
	  {
		  System.out.println("Success :" +testResult.getName());
	  }
  }

}
