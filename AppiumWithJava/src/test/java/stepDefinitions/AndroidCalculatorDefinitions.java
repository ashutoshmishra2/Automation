package stepDefinitions;

import org.openqa.selenium.By;
import org.junit.Assert;
import core.FrameworkRunner;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.AssertionFailedError;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.core.Serenity;
import utils.AndroidActions;


public class AndroidCalculatorDefinitions {

	//@Steps
	AndroidActions androidAction = new AndroidActions();
	
	@SuppressWarnings("rawtypes")
	public boolean directOperation(AndroidDriver driver, By locator, String operationFormulae, String expectedResult){
		
		//Sending complete formulae 
			driver = androidAction.doSendInput(driver, locator, "2+5=");
		//getting result text
			String result = androidAction.getValue(driver, By.xpath("//android.widget.TextView[@index='2']"));
		//Assert
			try{
				Assert.assertTrue("Expected == Actual", result.equals(expectedResult) );
			}catch(AssertionFailedError e){
				return false; //return the operation status.
			}
		return true; //return the operation status.
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param driver
	 * @return driver
	 * @desc Method for Sum operation on android calculator app.
	 */
	@SuppressWarnings("rawtypes")
	public boolean sum(AndroidDriver driver) {
		
		//putting values By Clicking on buttons
		driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='2']"));
//		driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/op_add']")); //addition
//		driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='5']"));
//		driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='=']"));
		
		//Taking Screenshot
		Serenity.takeScreenshot();
		
		// getting Result
		String actualResult = androidAction.getValue(driver, By.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']"));
		String expectedResult = "7";
		
		//Assert
		try{
			System.out.println(" RES >>>>>>>" + actualResult);
			Assert.assertTrue("Expected == Actual", actualResult.equalsIgnoreCase(expectedResult) );
		}catch(AssertionFailedError e){
			return false; //return the operation status.
		}
		return true; //return the operation status.
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param driver
	 * @return driver
	 */
	@SuppressWarnings("rawtypes")
	public boolean sub(AndroidDriver driver){
		
		//putting values By Clicking on buttons
		driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='2']"));
		driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/op_sub']")); // subtract
		driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='5']"));
		driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='=']"));
		
		// getting Result
		String actualResult = androidAction.getValue(driver, By.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']"));
		String expectedResult = "-?3";
		
		//clearing result
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='CLR']"));
			
		//Assert
		try{
			System.out.println(" RES >>>>>>>" + actualResult);
			Assert.assertTrue("Expected == Actual", actualResult.equalsIgnoreCase(expectedResult) );
		}catch(AssertionFailedError e){
			return false; //return the operation status.
		}
		return true; //return the operation status.
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param driver
	 * @return driver
	 */
	@SuppressWarnings("rawtypes")
	public boolean mul(AndroidDriver driver){
		//putting values By Clicking on buttons
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/op_sub']"));
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='2']"));
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/op_mul']")); //multiplication
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='5']"));
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='=']"));
		
		// getting Result
			String actualResult = androidAction.getValue(driver, By.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']"));
			String expectedResult = "10";
		
		//clearing result
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='CLR']"));

		//Assert
			try{
				System.out.println(" RES >>>>>>>" + actualResult);
				Assert.assertTrue("Expected == Actual", (actualResult.substring(actualResult.lastIndexOf('1'), actualResult.length())).equalsIgnoreCase(expectedResult) );
			}catch(AssertionFailedError e){
				return false; //return the operation status.
			}
		return true; //return the operation status.
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param driver
	 * @return driver
	 */
	@SuppressWarnings("rawtypes")
	public boolean div(AndroidDriver driver){
		
		//putting values By Clicking on buttons
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='2']"));
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/op_div']")); //division
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='0']"));
			driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='=']"));
		
		// getting Result
			String actualResult = androidAction.getValue(driver, By.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']"));
			//String expectedResult = "0.4";
			String expectedResult = "Can't divide by 0";
		
		//clearing result
			// if result opeation did not get succeded then below code will throw error 
			//driver = androidAction.doClick(driver, By.xpath("//android.widget.Button[@text='CLR']"));
		
		//Assert
			try{
				System.out.println(" RES >>>>>>>" + actualResult);
				Assert.assertTrue("Expected == Actual", actualResult.equalsIgnoreCase(expectedResult) );
			}catch(AssertionFailedError e){
				return false; //return the operation status.
			}
		return true; //return the operation status.
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param driver
	 * @return driver
	 */
	@SuppressWarnings("rawtypes")
	public AndroidDriver modDiv(AndroidDriver driver){
		return driver;
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param driver
	 * @return driver
	 */
	@SuppressWarnings("rawtypes")
	public AndroidDriver clrscr(AndroidDriver driver, By locator){
		FrameworkRunner.driver.findElement(locator).clear();
		return driver;
	}
	
	/**
	 * @author Ashutosh Mishra
	 * @param driver
	 * @return driver
	 */
	@SuppressWarnings("rawtypes")
	public AndroidDriver delete(AndroidDriver driver){
		FrameworkRunner.driver.findElement(By.xpath("//android.widget.Button[@text='DEL']")).click();
		return driver;
	}
}
