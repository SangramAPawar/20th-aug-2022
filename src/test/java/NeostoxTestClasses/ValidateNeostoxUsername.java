package NeostoxTestClasses;

import org.testng.annotations.Test;

import MyNeoStoxBase.Base;
import NeoStoxPOMClasses.MobileNoEnter1;
import NeoStoxPOMClasses.NeoStosPasswordPage1;
import NeoStoxPOMClasses.NeostoxDashBoardPage1;
//import MyNeoStoxPOMClass.MobileNoEnter1;
//import MyNeoStoxPOMClass.NeoStosPasswordPage1;
//import MyNeoStoxPOMClass.NeostoxDashBoardPage1;
//import MyNeoStoxPOMClass.NeostoxHomePage1;
//import MyNeoStoxUtility.Utility;
//import NeoStoxPOMClassesUsingDDF.MobileNoEnter;
//import NeoStoxPOMClassesUsingDDF.NeoStosPasswordPage1;
//import NeoStoxPOMClassesUsingDDF.NeostoxHomePage1;
import NeoStoxPOMClasses.NeostoxHomePage1;
import NeoStoxPOMClasses.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
@Listeners(NeostoxTestClasses.Listeners.class)
public class ValidateNeostoxUsername extends Base
{

	    
	   // NeostoxHomePage1 neo;
		//MobileNoEnter1 moen;
		//NeoStosPasswordPage1 password;
		//NeostoxDashBoardPage1 dashboard;
		//String s="TCID-1234";
		//String s2="TCID-8123";
	
	NeostoxHomePage1 neo;
	MobileNoEnter1 moen;
	NeoStosPasswordPage1 password;
	NeostoxDashBoardPage1 dashboard;
		
  
  
  @BeforeClass
  public void LaunchNeoStoxApp() throws IOException 
  {
	    launchBrowser();
	    neo = new NeostoxHomePage1(driver);
		moen = new MobileNoEnter1(driver);
		password = new NeoStosPasswordPage1(driver);
		dashboard= new NeostoxDashBoardPage1(driver);
  }
  
  @BeforeMethod
  public void logInToNeoStoxreClass() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	    neo.ClickOnSignin();
		Utility.implicitWait(1000, driver);
		
		moen.enterMobileNumber(Utility.readDataFromPropertyFile("mobile"));
		Thread.sleep(1000);
		moen.clickOnSignInButton();
		
		Utility.implicitWait(1000, driver);
		password.enterPassword(Utility.readDataFromPropertyFile("password"));
		Thread.sleep(1000);
		
		password.clickOnSubmitButton();
		
		Utility.implicitWait(1000, driver);
		
		dashboard.PopUpHandle(driver);
		
		Utility.implicitWait(1000, driver);
  }
  
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
  {
	 // Assert.fail();
	  Assert.assertEquals(dashboard.getActualUserName(),Utility.readDataFromPropertyFile("userName"),
			  "actual and expected username are not matching TC failed");
	  
	  Utility.takescreenshot(driver, Utility.readDataFromPropertyFile("TCID1"));
  }
  
  @Test()
  public void validateAccountBalence() throws IOException
  {
	  Assert.assertNotNull(dashboard.getAcBalence(),"AC balence is null TC failed");
	  Utility.takescreenshot(driver, Utility.readDataFromPropertyFile("TCID2"));
  }

  @AfterMethod
  public void logOutFromNeoStox() throws InterruptedException 
  {
	  dashboard.LogoutFromNeoStox();
  }
  
  

  @AfterClass
  public void closeNeoStoxApp() throws InterruptedException 
  {
	  driver.close();
	  Reporter.log("closing the application",true);
	  Thread.sleep(1000);
  }

}
