package pages.classes;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import  utils.ScreenShot;
import pagePOM.LoginPageLetsKodeIT;

public class LoginScriptValidationLetsKodeIt {

	private static WebDriver driver;
	private String baseURL;
	private WebElement element;

	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		
		baseURL = "https://www.letskodeit.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Parameters({"mailid","password"})
	@Test
	public void takeSS(String mailid, String password) throws InterruptedException {
		driver.get(baseURL);
		LoginPageLetsKodeIT lp=new LoginPageLetsKodeIT(driver);
		lp.clickSigninButton();
		lp.enterEmail(mailid);
		lp.enterPassword(password);
		lp.clickLoginButton();
		lp.verifyloginpage(driver);
		
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		System.out.println("status = "+result.getStatus());
		System.out.println(ITestResult.FAILURE);
		if(result.getStatus()== ITestResult.FAILURE)
		{
			System.out.println("inside after method assert condn");
			System.out.println("test name = "+result.getName());
			utils.ScreenShot.takeScreenShot(driver, result.getName());
			System.out.println("screenshot taken");
		} 
		driver.quit();
	}
}