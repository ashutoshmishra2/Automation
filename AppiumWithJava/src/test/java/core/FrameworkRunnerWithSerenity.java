package core;

import java.net.MalformedURLException;

import javax.swing.JOptionPane;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Steps;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/features", glue="stepDefinitions")

public class FrameworkRunnerWithSerenity {

		@Steps
		//public static FrameworkForAndroid frameworkObj = new FrameworkForAndroid();
		public static FrameworkForAndroid frameworkObj = new FrameworkForAndroid();
		public static AndroidDriver driver = null;
		
		/**
		 * @author Ashutosh Mishra
		 * @throws MalformedURLException
		 * @throws NullPointerException
		 */
		@BeforeClass()
		public static void init() throws MalformedURLException, NullPointerException{
			System.out.println("Initializing the testing invironment....");
			driver = frameworkObj.androidDriverSetup();
			
			//Getting A Message Digest for a particular string...
//			try {
//				System.out.println( utils.CryptNNG.md5("WINDOWS-000X64-XXMYPC-XXXXYZ-AAAAAA") );
//				javax.swing.JOptionPane.showMessageDialog(null, utils.CryptNNG.md5("WINDOWS-000X64-XXMYPC-XXXXYZ-AAAAAA"), "PRODUCT LICENSE KEY", JOptionPane.INFORMATION_MESSAGE);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}

		/**
		 * Ending the test.
		 */
		@AfterClass()
		public static void end(){
			System.out.println("Ending/finishing the testing environemnt....");
			frameworkObj.quitDriver(driver);
		}
}
