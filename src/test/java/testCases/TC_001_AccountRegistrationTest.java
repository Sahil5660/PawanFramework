package testCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	//public WebDriver driver;
	AccountRegistrationPage page;

	
	@Test(groups = {"Regression","Master"})
	public void registerTest() throws InterruptedException {
		logger.debug("Application logs***********");
		logger.info("Starting test cases********TC_001_AccountRegistrationTest");
		try {
			
		HomePage h=new HomePage(driver);
		
		h.MyAccount();
		Thread.sleep(2000);
		h.clickRegister();
		
		logger.info("Account registration process");
		
		page=new AccountRegistrationPage(driver);
		page.setFirstName(randomString());
		page.setLastName(randomString());
		page.setEmail(randomString()+"@gmail.com");
		page.setPassword(randomAlphaNumeric());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		page.TermsConditions();
		logger.info("Clicking on continue");
		page.clickSubmit();
		String msg=page.getConfirmationMsg();
		
		logger.info("Validating expected message");
		Assert.assertEquals(msg, "Register Account");
		
		  } 
		  catch(Exception e) {
			  logger.error("test failed	");
			  Assert.fail(); 
			  }//input[@name='password']
		
		logger.info("Finished this test case**********TC_001_AccountRegistrationTest ");
		 
			
		}
}
