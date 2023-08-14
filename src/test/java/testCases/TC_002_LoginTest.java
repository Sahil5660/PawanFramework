 package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	//public WebDriver driver;
	LoginPage page2;
	HomePage h;

	
	@Test(groups = {"Sanity","Master"})
	public void loginTest() throws InterruptedException {
		logger.debug("Application logs***********");
		logger.info("Starting test cases********TC_002_LoginTest");
		try {
			
		h=new HomePage(driver);
		h.MyAccount();
		MyAccountPage p=new MyAccountPage(driver);
		Thread.sleep(2000);
		h.clickLogin();
		
		logger.info("Account Login process");
		
		page2=new LoginPage(driver);
		page2.emailID(rb.getString("email"));
		page2.passwordValue(rb.getString("password"));
		
		
		logger.info("Clicked on loginButton");
		
		page2.clickOnLoginBtn();
		boolean targetPage=p.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true, "Invalid login data");
		

		}
		
			catch(Exception e)
			{
             Assert.fail();
			}
		
		logger.info("Finished this test case**********TC_002_LoginTest ");
	}
}
