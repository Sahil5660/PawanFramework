package testBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;  //To load the config.properties file
	
	@BeforeClass (groups = {"Sanity","Master","Regression"})
	@Parameters("browser")
	  public void setup(String br) throws InterruptedException {
	 
	  logger=LogManager.getLogger(this.getClass()); //this.getClass() is to represent the current class
	  
	  rb=ResourceBundle.getBundle("config"); //To load the config.properties file
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriverManager.firefoxdriver().setup();
	  WebDriverManager.edgedriver().setup();
	  
	  ChromeOptions op1=new ChromeOptions(); 
	  FirefoxOptions op2=new FirefoxOptions();
	  EdgeOptions op3=new EdgeOptions();
	  
	  op1.addArguments("--Remote-allow-origins=*"); 
	  op2.addArguments("--Remote-allow-origins=*");
	  op3.addArguments("--Remote-allow-origins=*");
	 // op1.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  
	  if(br.equals("chrome")) {
		driver=new ChromeDriver(op1);
	  }
	  else if(br.equals("edge")) {
		  driver=new EdgeDriver(op3);
	  }
	  else{
		  driver=new FirefoxDriver(op2);
	  } 
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get(rb.getString("appURL"));
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  //Thread.sleep(5000); 
	  }
	
	@AfterClass(groups = {"Sanity","Master","Regression"})
	public void tearDown() {
		//driver.quit();
		
		
	}
	//To generate the random String
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(10);
		return (generatedString);
		
	}
	
	public String randomNumber() {
		String generatedString2=RandomStringUtils.randomNumeric(10);
		return (generatedString2);
		
	}
	public String randomAlphaNumeric() {
		String num=RandomStringUtils.randomNumeric(4);
		String str=RandomStringUtils.randomAlphabetic(3);
		return (num+"@"+str);
		
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
