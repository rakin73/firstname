package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.apache.commons.io.FileUtils;
public class base {
public static WebDriver driver;
public Properties  prop;
	public WebDriver initializeDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis =new FileInputStream("/Users/rakinsarwar/E2EProject/src/test/resource/Properites/data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","/Users/rakinsarwar/Downloads/chromedriver" );
        driver = new ChromeDriver();
}
		
	else if (browserName.equals("firefox")) {
	System.setProperty("webdriver.firefox.driver","/Users/rakinsarwar/Downloads/Firefoxdriver");
	driver= new FirefoxDriver();
	}
	else if (browserName.equals("Safari")) {
		System.getProperty("webdriver.safari.driver", "/Users/rakinsarwar/Downloads/Safaridriver");
		driver= new SafariDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	
	public void getScreenshot(String result) throws IOException{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("/Users/rakinsarwar/Documents/javascreenshot/"+result+"screen shot.png"));
	}
	
	
	
}
