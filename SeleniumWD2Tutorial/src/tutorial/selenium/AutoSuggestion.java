package tutorial.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoSuggestion {
	private static WebDriver driver;
	private String baseURL;
	private WebElement element;
	 
	
	@BeforeClass
	public void setUp()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		System.out.println("browser opened");
		baseURL = "https://www.google.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("before class ends");
		
		/*ChromeOptions option = new ChromeOptions();
		  option.addArguments("--remote-allow-origins=*");
		  driver = new ChromeDriver(option);
		  System.out.println("browser opened");
		  baseURL = "https://www.google.com";
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		  System.out.println("before class ends");
		//  driver.get(baseURL);
		  */
		
	}
  @Test
  public void handleAutoSuggestions() {
	  System.out.println("TEst method starts");
	  driver.get(baseURL);
	  
	 element =  driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
	 element.sendKeys("java");
	// ArrayList li=new ArrayList();
	 List<WebElement> li = driver.findElements(By.xpath("//div[@id='Alh6id']//li"));
	 
	
	 for(WebElement e:li)
	 {
		 System.out.println(e.getText());
		
	 }
	 
	 element = driver.findElement(By.xpath("//div[@id='Alh6id']//li[7]"));
	 element.click();
	 }
}
