package Step;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.base;
import pageObject.LandingPaage;
import pageObject.LoginPage;

public class Homepage extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
@BeforeTest

public void initialize() throws IOException {
	
driver=initializeDriver();
log.info("Driver is initialized");
}


	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException {
		
		driver.get(prop.getProperty("url"));
		LandingPaage l =new LandingPaage(driver);
	 l.getLogin().click();
	 
	 LoginPage lp =new LoginPage(driver);
	 lp.getUser().sendKeys(username);
	 lp.getPass().sendKeys(password);
	//System.out.println(text);
	 lp.getLogin().click();

	}
	@DataProvider
	public Object[][] getData() {
		//row stands for how many different data types test should run
		//coloum stands for how many values per each test
		//Array size is 5 is starts from zero 
		Object[][] data= new Object[2][2];
		data [0][0]="rakin33@gmail.com";
		data[0][1]="asdcf";
		//data[0][2]="restrcited user";
		data[1][0]="restricteduser@qw.com";
		data[1][1]="12234";
		//data[1][2]="Non restricteduser";
		
		return data;
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	
	
}
