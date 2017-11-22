package core;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class FrameworkForLoadedAndroidApp {
	
	/** 
	 * Android Driver and other variables
	 */
		@SuppressWarnings("rawtypes")
		public AndroidDriver driver = null;
		
	/**
	 * Public Variables for desired capabilities on Android
	 */
		public String APPIUM_URL 		= "http://127.0.0.1:4723/wd/hub";		//Specific complete address, where appium server is running and listening 
		public String PLATFORM_NAME 	= "Android";							//Specification of Mobile Platform either of "Android" || "iOS"
		public String PLATFORM_VERSION 	= "7.1.1";								//Specification of Mobile platform version
		public String DEVICE_NAME 		= "Android";							//Device Name.
		public String APP_PACKAGE 		= "com.android.calculator2";			//Name of the application package.
		public String APP_ACTIVITY 		= "com.android.calculator2.Calculator";	//Name of the application activity from where to start.
		public String APP 				= "E:\\__Codes\\AutomationWorkspace\\AppiumDemoMed_Helper_Pill_Reminder_v2.8.0.apk";//In case if we want to load an android application from a given location.
		
	/**
	 * method for Android driver setup.
	 */
		@SuppressWarnings("rawtypes")
		public AndroidDriver androidDriverSetup() throws MalformedURLException{
				//TODO:
				System.out.println( "I am Driver\n Here is Object Value(Object Reference) Value: " );
		        DesiredCapabilities capabilities = new DesiredCapabilities();
		        
		    	capabilities.setCapability("platformName", 		this.PLATFORM_NAME);
		        capabilities.setCapability("platformVersion", 	this.PLATFORM_VERSION); //Android API Version
		        capabilities.setCapability("deviceName", 		this.DEVICE_NAME);
		        //capabilities.setCapability("appPackage", 		this.APP_PACKAGE);
		        //capabilities.setCapability("appActivity", 		this.APP_ACTIVITY);
		        // In case i have to load a particuler apk file to emulator then we will use this desire capability
		        capabilities.setCapability("app", this.APP);
		        
		        //Initializing the driver
		        try{
		        	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		        }catch(NullPointerException e){
		        	System.out.println( "Oopse, driver not initialized" );
		        }catch(org.openqa.selenium.SessionNotCreatedException e){
		        	System.out.println( "Oopse, Session not created" );
		        }catch(Exception e){ 
		        	System.out.println("Another Exception occured."); e.printStackTrace(); }
		        finally{
		        	System.out.println( driver );
		        }
		        
		        //Return the driver object.
		        return driver;
		}
		
	/**
	 * method to quit AndroidDriver instance
	 */
		@SuppressWarnings("rawtypes")
		public boolean quitDriver(AndroidDriver ado){
			try{
				ado.quit();
			}catch(Exception e){
				return false;
			}
			return true;
		}
}
