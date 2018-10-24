package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPaage {

	public WebDriver driver;
	By login=By.xpath("/html/body/header/div[1]/div/nav/ul/li[4]/a/span");
	By title = By.cssSelector(".text-center>h2");
	
	
	public LandingPaage(WebDriver driver) {
		
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
}
