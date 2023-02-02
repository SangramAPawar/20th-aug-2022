package MyNeoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import NeoStoxPOMClasses.Utility;

//import MyNeoStoxUtility.Utility;

public class Base
{
	
	protected  static WebDriver driver;
	public void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp\\Desktop\\crdriver\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.get("https://neostox.com/");
		
		driver.get(Utility.readDataFromPropertyFile("urlqa"));
		
		Utility.implicitWait(1000,driver);
		Reporter.log("Launching browser",true);
		
	}

}
