package pages.classes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Grouping {

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
	
	@Test(groups= {"BMW","Sedan"})
	public void BMW3Series()
	{
		System.out.println("Running test-->BMW3Series");
	}
	@Test(groups= {"BMW","suv"})
	public void BMWx3()
	{
		System.out.println("Running test-->BMWx3");
	}
	@Test(groups= {"audi","Sedan"})
	public void AudiA6()
	{
		System.out.println("Running test-->AudiA6");
	}
	@Test(groups= {"honda","Sedan"})
	public void HondaAccord()
	{
		System.out.println("Running test-->HondaAccord");
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

