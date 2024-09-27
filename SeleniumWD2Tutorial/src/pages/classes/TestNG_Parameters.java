package pages.classes;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parameters {
	private WebDriver driver;
	private String baseURL;
	private JavascriptExecutor js;
	//static Logger log =Logger.getLogger(UsingLog4j.class);
	
	@DataProvider(name="fieldsInputs")
	public static Object[][] searchData() {
		return new Object[][] {{"bengaluru", "pune", 30},
				{"New York", "Boston", 29}};
	}
	
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
  
  
  @Test(dataProvider = "fieldsInputs")
  public void checkFlightNew(String fromCity, String toCity, int departureDate) throws InterruptedException
  {
	 SearchPAge.fillFromCityTB(driver, fromCity);
	  SearchPAge.filltoCityTB(driver,toCity );
	 SearchPAge.SelectDepartureDate(driver,departureDate );
	// SearchPAge.clickonSearchButton(driver);
	  
  }
  
  @BeforeClass
  public void setUp() {
	  ChromeOptions option = new ChromeOptions();
	  option.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(option);
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
