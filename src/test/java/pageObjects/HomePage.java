package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//Invoking parent class constructor by using below constructor
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		
		
	}
	
	//Locators 
	@FindBy(xpath="//span[text()='My Account']")
	WebElement Click_My_Account;
	
	@FindBy(linkText="Register")
	WebElement lnkRegister;
	
	@FindBy(linkText="Login")
	WebElement login;
	
	
//Actions Methods
public void MyAccount() {

	Click_My_Account.click();
	
}

public void clickRegister() {
	lnkRegister.click();
}

public void clickLogin() {
	login.click();
}

}
	


