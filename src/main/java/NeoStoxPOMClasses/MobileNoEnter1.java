package NeoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MobileNoEnter1 
{
    @FindBy(xpath = "(//input[@type='number'])[1]")private WebElement MobileNumField;
    @FindBy(xpath = "//a[@id='lnk_signup1']") private WebElement signInButton;
    
    public MobileNoEnter1(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void enterMobileNumber(String mobNumber)
    {
    	MobileNumField.sendKeys(mobNumber);
    	Reporter.log("entering mobile number", true);
    }
    public void clickOnSignInButton()
    {
    	signInButton.click();
    	Reporter.log("click on sign in", true);
    }

	
		
	
}

