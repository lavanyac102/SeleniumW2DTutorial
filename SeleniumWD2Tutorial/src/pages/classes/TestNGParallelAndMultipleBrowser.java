package pages.classes;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParallelAndMultipleBrowser {
	
	private WebDriver driver;
	private String baseURL;
	private JavascriptExecutor js;
	@Test
	  public void closeModal() throws InterruptedException {
		  SearchPAge.clickCloseModal(driver);	 
	  }
	  @Parameters({"fromCity","toCity","departureDate"})
	  @Test(dependsOnMethods = "closeModal")
	  public void checkFlight(String fromCity, String toCity, int departureDate) throws InterruptedException
	  {
		 SearchPAge.fillFromCityTB(driver, fromCity);
		  SearchPAge.filltoCityTB(driver,toCity );
		 SearchPAge.SelectDepartureDate(driver,departureDate );
		 SearchPAge.clickonSearchButton(driver);
		  
	  }
	  @Parameters("browserType")
	  @BeforeClass
	  public void setUp(String browser) {
		  if(browser.equalsIgnoreCase("chrome"))
		  {
			  ChromeOptions option = new ChromeOptions();
			  option.addArguments("--remote-allow-origins=*");
			  driver = new ChromeDriver(option);
		  }
		  else if(browser.equalsIgnoreCase("firefox"))
		  {
			  driver = new FirefoxDriver();  
		  }
		  baseURL = "https://www.makemytrip.com";
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		  driver.get(baseURL);
		
	  }

	  @AfterClass
	  public void afterMethod() {
		 driver.quit();
	  }
}
