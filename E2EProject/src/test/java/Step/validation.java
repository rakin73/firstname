package Step;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.base;
import pageObject.LandingPaage;

public class validation extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
	driver=initializeDriver();
	driver.get(prop.getProperty("url"));
	log.info("Driver is initialized");
	}
	
	@Test()
	public void basePageNavigation() throws IOException {
		
		
		 LandingPaage l =new LandingPaage(driver);
		//compare the text text from the browers with the actual text
		 AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Navigate to homepage");
	
	
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	
	
}
