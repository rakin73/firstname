package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	By username=By.id("user_email");
	By password=By.id("user_password");
	By login =By.xpath("/html/body/div/div/div/div/div/div/div[1]/div/form/div[3]/input");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	
	public WebElement getUser() {
		return driver.findElement(username);
	}
	public WebElement getPass() {
		return driver.findElement(password);
	}
	
	
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	
	
}
