package pages.classes;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNG_ReportersAndAsserts {
  
	@Test
	public void testStrings()
	{
		String actualString="TestReporters and Assrets";
		Reporter.log("Actual String is "+ actualString,true);
		Assert.assertEquals(actualString, "TestReporters and Assrets");
		Reporter.log("veryifyng actual value with expected value",true);
		Reporter.log("");
	}
	
	@Test
	public void testInt()
	{
		int actualInt = 10;
		Reporter.log("Actual integer is "+ actualInt,true);
		Assert.assertEquals(actualInt, 10);
		Reporter.log("veryifyng actual value with expected value",true);
		Reporter.log("");
		
	}
	
	@Test
	public void testArrays()
	{
		int array1[]= {10,20,30};
		int array2[]= {10,20,30};
		Reporter.log("Actual array1 is : "+ array1, true);
		Reporter.log("Actual array2 is : "+ array2, true);
		Assert.assertEquals(array1, array2);
		Reporter.log("Veryfying array1 and array2",true);
		Reporter.log("");
		
		
				
	}
}
