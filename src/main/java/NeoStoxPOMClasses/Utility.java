package NeoStoxPOMClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility 
{
	    //excel
		//waits
		//screenshots
		//scrollIntoView
	   // properties file
	
		public static String readDataFromPropertyFile(String key) throws IOException
		{
			// 1. create object of a properties file
			Properties prop = new Properties();
			
			//2.create object of file input stream
			FileInputStream myFile= new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\20_Aug_Eve_MVN\\myProperty.properties");
			
			//3.load file
			prop.load(myFile);
			
			//4. read data from file
			String value = prop.getProperty(key);
			
			Reporter.log("reading data from excel row is ", true);
			Reporter.log("data is"+value,true);
			
			return value;
			
		}
		
	/*	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
		{
			File myfile= new File("C:\\Users\\hp\\Desktop\\crdriver\\20AugEvening.xlsx");
			Sheet mysheet = WorkbookFactory.create(myfile).getSheet("Sheet5");
			String value = mysheet.getRow(row).getCell(cell).getStringCellValue();
			Reporter.log("reading data from excel rw is "+row+"cell is"+cell,true);
			Reporter.log("data is"+value, true);
			return value;
		}*/
		
		public static void implicitWait(int time, WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
			Reporter.log("waiting for"+time+"ms",true);
		}
		
		public static void takescreenshot(WebDriver driver, String fileName) throws IOException
		{
			 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 String s=RandomString.make(2);
			 File dest = new File("C:\\Users\\hp\\Desktop\\crdriver\\screenshots\\"+fileName+s+".png");
			 FileHandler.copy(src, dest);
			 Reporter.log("taking screenshot", true);
			 Reporter.log("screenshot taken and saved at"+dest, true);
			 
		}
		
		public static void scrollIntoView(WebDriver driver , WebElement element)
		{
	         JavascriptExecutor js = (JavascriptExecutor)driver;
	         js.executeScript("arguments[0].scrollIntoView(true)", element);
	         Reporter.log("scrolling into view to"+element.getText(), true);
		}

		
		

}
