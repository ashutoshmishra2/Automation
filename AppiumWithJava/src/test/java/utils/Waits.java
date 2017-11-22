package utils;

import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;

public class Waits {

	/**
	 * 
	 * @param driver
	 * @param waitTimeInSeconds
	 * @author Ashutosh Mishra
	 * @desc method for explicit wait
	 */
	public static void exWait(AndroidDriver driver, Integer waitTimeInSeconds){
		driver.manage().timeouts().implicitlyWait(waitTimeInSeconds, TimeUnit.SECONDS);
		//return driver;
	}
	
	/**
	 * Method for wait on expected conditions.
	 */
}
