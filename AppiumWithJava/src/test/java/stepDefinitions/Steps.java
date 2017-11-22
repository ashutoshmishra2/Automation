package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.awt.Frame;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import core.FrameworkForAndroid;
import stepDefinitions.AndroidCalculatorDefinitions;
import utils.Waits;
import core.FrameworkRunner;

public class Steps {

	AndroidCalculatorDefinitions calc = new AndroidCalculatorDefinitions();
	
	@Given("^I want tooo lounch my application$")
	public void i_want_tooo_lounch_my_application() throws MalformedURLException{
		System.out.println("AndroidDriver Setup and initialization.");
		//Waits.exWait(FrameworkForAndroid.driver, 15);
	}
	
	@Then("^I want tooo perform addition and check outcomes$")
	public void i_want_to_perform_addition_and_check_outcomes() {
		System.out.println("Executing Calc Operation");
		
		FrameworkRunner.driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		
		//FrameworkForAndroid.driver.findElement(By.className("android.widget.Button[@index=\"4\", @text=\"5\"")).click();
		//Pause/sleep
		  try {
			Thread.sleep(5000);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		//FrameworkForAndroid.driver  = calc.sub(FrameworkForAndroid.driver);
	}
	
	

}
