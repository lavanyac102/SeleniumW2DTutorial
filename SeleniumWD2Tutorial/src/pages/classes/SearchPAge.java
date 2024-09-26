package pages.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.apache.log4j.Logger;


public class SearchPAge {
	public static WebElement element = null;
	private static JavascriptExecutor js;

	public static void clickCloseModal(WebDriver driver) throws InterruptedException
	{
		element=driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
		element.click();
		Thread.sleep(3000);
	}
	public static WebElement fromCityTB(WebDriver driver) {
		element = driver.findElement(By.id("fromCity"));
		return element;
	}

	public static void fillFromCityTB(WebDriver driver, String from) throws InterruptedException {
		System.out.println(from);
		element = fromCityTB(driver);
		element.sendKeys(from);
		 driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
		Thread.sleep(3000);
	}

	public static WebElement toCityTB(WebDriver driver) {
		element = driver.findElement(By.id("toCity"));
		return element;
	}

	public static void filltoCityTB(WebDriver driver, String to) throws InterruptedException {
		System.out.println(to);
		element = toCityTB(driver);
		element.sendKeys(to);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
		Thread.sleep(1000);
	}

	public static WebElement findDepartureDateElement(WebDriver driver) throws InterruptedException {
		element = driver.findElement(By.xpath("//p[@data-cy='departureDate']"));
		System.out.println(element);
		
		return element;
	}

	public static void SelectDepartureDate(WebDriver driver, int date) throws InterruptedException {
		element = findDepartureDateElement(driver);
		System.out.println(element);
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		// select date from calendar
		WebElement calBody = driver.findElement(By.xpath("(//div[@class='DayPicker-Body'])[1]"));
		Thread.sleep(3000);
		List<WebElement> calBodyList = calBody.findElements(By.tagName("p"));
		System.out.println("Size of list :" + calBodyList.size());

		for (WebElement d : calBodyList) {
			System.out.println(d.getText());
			if (d.getText().equals(date + "")) {
				d.click();
				System.out.println("date matching");

				break;
			}
		}
	}
	
	public static void clickonSearchButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
		element.click();
	}

}
