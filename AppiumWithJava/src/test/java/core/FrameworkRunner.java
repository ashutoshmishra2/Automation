package core;

import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.android.AndroidDriver;
/*
 * ====================================================================
 * @Date	: 17 Feb 2017 | Updated: 4 August 2017
 * @Author	: Ashutosh Mishra (ashutosh.mishra@mindfiresolutions.com)
 * @Desc	: Selenium Automation with Cucumber with Appium.
 * ====================================================================
 */
/* 
 * -------------------------------------------------
 * Run with Cucumber class with the following setup 
 * -------------------------------------------------
 * */
//"pretty", 
@RunWith(Cucumber.class)
@CucumberOptions(
		format	=	{"json:target/JSONReport/FrameworkOutput.json", "html:target/HTMLReport"}, /* Report location */
		features=	{"src/features"}, 													/* Feature Files location */
		glue 	=	{"stepDefinitions"}														/* Looks for specified PackageName, From Where Cucumber will pickup test definitions for feature file Steps*/
)

public class FrameworkRunner {
	
	
	//Android Driver initialization
	public static FrameworkForAndroid frameworkObj = new FrameworkForAndroid();
	@SuppressWarnings("rawtypes")
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
