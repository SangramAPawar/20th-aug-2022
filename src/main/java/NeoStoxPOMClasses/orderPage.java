package NeoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class orderPage 
{

	@FindBy(xpath="(//a[text()='Sign In'])[1]")private WebElement SignInButton;
   
	// initialize within the constructor with access level public using page factory
   public orderPage(WebDriver driver)
   {
	  PageFactory.initElements(driver, this); 
   }
   // utilize within a method with access level public
   public void ClickOnSignin()
   {
	   SignInButton.click();
	   Reporter.log("Clicking on signin button", true);
   }
}
