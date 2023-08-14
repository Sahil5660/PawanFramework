package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_TestDDT extends BaseClass{
	
	
	/*
	 * LoginPage page2; HomePage h;
	 * 
	 * 
	 * @Test(dataProvider="LoginData",dataProviderClass = DataProviders.class) //We
	 * are providing the data provider class name public void testDDT(String
	 * email,String password,String exp) throws InterruptedException {
	 * logger.info("****Test case in start TC_003_TestDDT"); try {
	 * 
	 * h=new HomePage(driver); h.MyAccount(); MyAccountPage p=new
	 * MyAccountPage(driver); Thread.sleep(2000); h.clickLogin();
	 * 
	 * page2=new LoginPage(driver); page2.emailID(email);
	 * page2.passwordValue(password);
	 * 
	 * page2.clickOnLoginBtn(); boolean targetPage=p.IsmyAccountPageExist();
	 * 
	 * 
	 * JavascriptExecutor js=(JavascriptExecutor)driver;
	 * js.executeScript("window.scrollBy(0,400)", "");
	 * 
	 * 
	 * if(exp.equals("Valid")) { //Verification with valid data
	 * 
	 * if(targetPage==true) { JavascriptExecutor js2=(JavascriptExecutor)driver;
	 * js2.executeScript("window.scrollBy(0,400)", ""); p.logOut();
	 * Assert.assertTrue(true); } else { Assert.assertFalse(false); }
	 * 
	 * }
	 * 
	 * if(exp.equals("Invalid")) { //Verification with invalid data
	 * 
	 * if(targetPage==true) { p.logOut(); Assert.assertTrue(false); } else {
	 * Assert.assertFalse(true); }
	 * 
	 * }
	 * 
	 * 
	 * } catch(Exception e) { Assert.fail();
	 * 
	 * } logger.info("*********Finished TC_003_TestDDT");
	 * 
	 * }
	 */
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			HomePage h = new HomePage(driver);
			h.MyAccount();
			h.clickLogin();

			LoginPage page2 = new LoginPage(driver);
			page2.emailID(email);
			page2.passwordValue(pwd);
			page2.clickOnLoginBtn();

			MyAccountPage p=new MyAccountPage(driver);
			boolean targetpage = p.isMyAccountPageExists();// this method is created MyAccountPage

			if (exp.equals("Valid")) {
				if (targetpage == true) {
					
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,500)", "");
					Thread.sleep(3000);
					p.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					MyAccountPage myaccpage = new MyAccountPage(driver);
					
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_003_LoginDataDrivenTest");

	}

}


