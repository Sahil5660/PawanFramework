package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	//Invoking parent class constructor by using below constructor
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		
		
	}
	
	//Locators 
	@FindBy(xpath="//input[@name='email']")
	WebElement enterEmailID;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement enterPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement clickLoginBtn;
	
	
	
	
//Actions Methods
public void emailID(String userEmail) {

	enterEmailID.sendKeys(userEmail);
	
}

public void passwordValue(String userPassword) {
	enterPassword.sendKeys(userPassword);
}

public void clickOnLoginBtn() {
	clickLoginBtn.click();
}



}
	


