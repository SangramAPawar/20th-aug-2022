package NeoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStosPasswordPage1 
{
      @FindBy(xpath="//input[@id='txt_accesspin']")private WebElement passwordField;
      
      @FindBy(xpath="//a[@id='lnk_submitaccesspin']")private WebElement submitButton;
      
     public NeoStosPasswordPage1(WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
     }
     
     public void enterPassword(String password)
     {
    	 passwordField.sendKeys(password);
    	 Reporter.log("entering password", true);
     }
     
     public void clickOnSubmitButton() throws InterruptedException
     {
    	 Thread.sleep(500);
    	 submitButton.click();
    	 Reporter.log("Clicking on submit button", true);
     }
}
