package utils;

import java.io.IOException;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShot
{
	public static void takeScreenShot(WebDriver driver, String fileName) throws IOException
	{
		fileName=fileName+".png";
		String directory = "C:\\Users\\VINAY\\Selenium\\failedTCScreenshots\\"; 
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(directory+fileName));
		
		
		
	}
}