package tutorial.selenium;

import java.time.Duration;
import java.util.List;
import pages.classes.SearchPAge;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_TestCASe {
	private WebDriver driver;
	private String baseURL;
	private JavascriptExecutor js;
	//static Logger log =Logger.getLogger(UsingLog4j.class);
  @Test
  public void closeModal() throws InterruptedException {
	  SearchPAge.clickCloseModal(driver);	 
  }
  
  @Test(dependsOnMethods = "closeModal")
  public void checkFlight() throws InterruptedException
  {
	 SearchPAge.fillFromCityTB(driver, "Bengaluru");
	  SearchPAge.filltoCityTB(driver, "pune");
	 SearchPAge.SelectDepartureDate(driver, 30);
	 SearchPAge.clickonSearchButton(driver);
	  
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
