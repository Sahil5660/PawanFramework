package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	//Locator
	@FindBy(xpath="//h2[text()='My Account']")  // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@class='list-group mb-3']//a[text()='Logout']")
    //div[@class='dropdown']//a[text()='Logout']
	WebElement lnkLogout;
	
	//Action method
	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());  // MyAccount Page heading display status
		}
		catch(Exception e){
			return (false);
		}
		
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}

}
