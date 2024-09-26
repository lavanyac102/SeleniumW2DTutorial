package pages.classes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Prioritization {
	@BeforeClass
	public void BeforeClass()
	{
		System.out.println("runs once before class\n");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("runs once before every method");
	}
	
	@Test(priority=0)
	public void BMW3Series()
	{
		System.out.println("Running test 1-->BMW3Series");
	}
	@Test(priority=1)
	public void BMWx3()
	{
		System.out.println("Running test 2-->BMWx3");
	}
	@Test(priority=2,enabled=false)
	public void AudiA6()
	{
		System.out.println("Running test 3-->AudiA6");
	}
	@Test(priority=3)
	public void HondaAccord()
	{
		System.out.println("Running test 4-->HondaAccord");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("runs once after every method\n");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("runs once after class\n");
	}
}
