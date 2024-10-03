package pagePOM;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageLetsKodeIT {
	
	@FindBy(xpath="//a[@href='/login']")
	private WebElement signIn;
	
	@FindBy(id="email")
	private WebElement loginTB;
	
	@FindBy(id="login-password")
	private WebElement passwordTb;
	
	@FindBy(id="login")
	private WebElement loginButton;
	
	public LoginPageLetsKodeIT(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickSigninButton() throws InterruptedException
	{
		signIn.click();
		Thread.sleep(2000);
	}
	public void enterEmail(String str)
	{
		loginTB.sendKeys(str);
	}
	public void enterPassword(String str)
	{
		passwordTb.sendKeys(str);
	}
	public void clickLoginButton() throws InterruptedException
	{
		loginButton.click();
		Thread.sleep(2000);
	}
	public void verifyloginpage(WebDriver driver)
	{
		/*Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
	System.out.println("alert message = "+alertMessage);	
	alert.accept();*/
	WebElement ele=null;
	try {
	ele =driver.findElement(By.xpath("//h1[contains(text(),'My Courses ')]"));
	System.out.println(ele.getText());
	}
	catch(NoSuchElementException e)
	{
	System.out.println("Error message = "+e.getMessage());	
	}
	Assert.assertTrue(ele != null);
	
	}
	
	
}