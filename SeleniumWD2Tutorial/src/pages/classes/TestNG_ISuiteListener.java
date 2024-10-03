package pages.classes;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_ISuiteListener {
	@BeforeClass
	public void setup() {
		System.out.println("code in before class");
	}

	@AfterClass
	public void cleanup() {
		System.out.println("code in after class\n");
	}

	@Test
	public void testMethod1() {
		System.out.println("code in testMethod1");
		Assert.assertTrue(true);
	}

	@Test
	public void testMethod2() {
		System.out.println("code in testMethod2");
		Assert.assertTrue(false);
	}
}
