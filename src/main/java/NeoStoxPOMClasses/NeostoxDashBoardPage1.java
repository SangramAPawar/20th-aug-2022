package NeoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxDashBoardPage1 
{
     
	  @FindBy(xpath="(//a[text()='OK'])[2]")private WebElement popUpOkButton;
      
      //@FindBy(linkText = "Close")private WebElement popUpCloseButton;
      
      @FindBy(xpath="//span[@id='lbl_username']")private WebElement userName;
      
      @FindBy(xpath="//span[text()='Logout']")private WebElement logoutButton;
      
      @FindBy(id="lbl_curbalancetop")private WebElement AcBalence;
      
      public NeostoxDashBoardPage1(WebDriver driver)
      {
    	  PageFactory.initElements(driver, this);
      }
      
      public void PopUpHandle(WebDriver driver) throws InterruptedException
      {
    	  
    	  Thread.sleep(5000);
    	 if(popUpOkButton.isDisplayed())
    	  {
    	  Utility.scrollIntoView(driver, popUpOkButton);
    	  popUpOkButton.click();
    	  Reporter.log("clickingon popUp Ok button", true);
    	  Thread.sleep(5000);
    	 // Utility.scrollIntoView(driver, popUpCloseButton);
    	 // popUpCloseButton.click();
    	 // Reporter.log("clickingon popUp close button", true);
    	  }
    	 else
    	  {
    		  Reporter.log("there is no popUp", true);
    	  }
      }
     
      
     
      public void LogoutFromNeoStox() throws InterruptedException
      {
    	  userName.click();
    	  Thread.sleep(1000);
    	  logoutButton.click();
    	  Reporter.log("logging out from neoStox", true);
    	  Thread.sleep(1000);
      }
      public String getActualUserName()
      {
    	  String actualUserName = userName.getText();
    	  Reporter.log("getting actual user name", true);
    	  Reporter.log(" actual user name is-->"+actualUserName, true);
		  return actualUserName;
      }
     public String getAcBalence()
     {
    	 String balence = AcBalence.getText();
    	 Reporter.log("getting account balence", true);
    	 Reporter.log("account balence is"+balence, true);
		 return balence;
     }
     public void hallo()
     {
    	 Reporter.log("getting account balence", true);
     }
}
