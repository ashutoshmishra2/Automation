package utils;

import java.nio.charset.Charset;

import org.openqa.selenium.By;

import core.FrameworkRunner;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {

	/**
	 * ===========================================================
	 * @author Ashutosh Mishra
	 * @param driver
	 * @param locator
	 * @return driver
	 * @desc method to perform Click operations on android locator 
	 * are type By. [ locator => By.xpath("//android.widget.Button[@text='2']") ]
	 * ===========================================================
	 */
	@SuppressWarnings("rawtypes")
	public AndroidDriver doClick(AndroidDriver driver, By locator){
		if(driver != null)
			driver.findElement(locator).click();
		else
			System.out.println("Null Driver");
		return driver;
	}
	
	/**
	 * ===========================================================
	 * @author Ashutosh Mishra
	 * @param driver
	 * @param locator
	 * @param input
	 * @return driver
	 * @desc method to set the input value to an element/component.
	 * ===========================================================
	 */
	
	@SuppressWarnings("rawtypes")
	public AndroidDriver doSendInput(AndroidDriver driver, By locator, String input){
		driver.findElement(locator).sendKeys(input);
		return driver;
	}
	
	@SuppressWarnings("rawtypes")
	public String getValue(AndroidDriver driver, By locator){
		//return driver.findElement(locator).getText();
		//Encodings
		byte[] ptext = (driver.findElement(locator).getAttribute("text")).getBytes( Charset.forName("UTF-8") ); 
		//return driver.findElement(locator).getAttribute("text");
		return new String(ptext, Charset.forName("UTF-8"));
	}
	
	@SuppressWarnings("rawtypes")
	public void clear(AndroidDriver driver, By locator){
		FrameworkRunner.driver.findElement(locator).clear();
	}
}
