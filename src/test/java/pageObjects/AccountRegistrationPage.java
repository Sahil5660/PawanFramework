package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	//Invoking parent class constructor by using below constructor
	public AccountRegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		
		
	}
	
	//Locators 
	
	
	@FindBy(name="firstname")
	WebElement Enter_FirstName_loc;
	
	@FindBy(name="lastname")
	WebElement Enter_LastName_loc;
	
	@FindBy(name="email")
	WebElement Enter_Email_loc;

	@FindBy(name="password")
	WebElement Enter_Password_loc;
	
	@FindBy(name="agree")
	WebElement Click_Checkbox_loc;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Click_Submit_loc;
	
	@FindBy(css="div[id='content'] h1")
	WebElement confMsg;
	
//Actions Methods
public void setFirstName(String FirstName) {

	Enter_FirstName_loc.sendKeys(FirstName);
	
}

public void setLastName(String LastName) {

	Enter_LastName_loc.sendKeys(LastName);
	
}

public void setEmail(String email) {

	Enter_Email_loc.sendKeys(email);
	
}

public void setPassword(String password) {

	Enter_Password_loc.sendKeys(password);
	
}

public void  TermsConditions() {

	Click_Checkbox_loc.click();
	
}

public void clickSubmit() {
	Click_Submit_loc.click();
}

public String getConfirmationMsg() {

	try {
		return(confMsg.getText());
	}
	catch(Exception e) {
		return(e.getMessage());
	}
	
}

}
	


