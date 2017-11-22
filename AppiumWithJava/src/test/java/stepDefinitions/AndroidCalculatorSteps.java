package stepDefinitions;

import core.FrameworkRunner;
import core.FrameworkRunnerWithSerenity;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class AndroidCalculatorSteps {

	/**
	 * Android Calculator Class Object.
	 * @Desc: Having all functionality of calculator controls [inputs, operations, modes]
	 */
	AndroidCalculatorDefinitions calc = new AndroidCalculatorDefinitions();
	Double result = new Double(0.000000);
	String res	= new String("");
	
	/**
	 * ---------------------------------------------------------------------------
	 * Methods for the feature steps.
	 * ---------------------------------------------------------------------------
	 */
	
	@Given("^I want to lounch android calculator$")
	public void i_want_to_lounch_android_calculator(){
	    //FrameworkRunner.driver;
		//Work already done by @beforeclass method.
	}

	@Then("^I want to perform addition and check outcomes$")
	public void i_want_to_perform_addition_and_check_outcomes() {
		System.out.println("Executing Calc + Operation >>>>> ");
		calc.sum(FrameworkRunnerWithSerenity.driver);
		System.out.println("End the sum step");
	}
	
	@Then("^I want to perform substraction and check outcomes$")
	public void i_want_to_perform_substraction_and_check_outcomes(){
		System.out.println("Executing Calc - Operation >>>>> ");
		calc.sub(FrameworkRunnerWithSerenity.driver);
	}

	@Then("^I want to perform multiplication and check outcomes$")
	public void i_want_to_perform_multiplication_and_check_outcomes() {
		System.out.println("Executing Calc * Operation >>>>> ");
		calc.mul(FrameworkRunnerWithSerenity.driver);
	}

	@Then("^I want to perform division and check outcomes$")
	public void i_want_to_perform_division_and_check_outcomes() {
		System.out.println("Executing Calc / Operation >>>>> ");
		calc.div(FrameworkRunnerWithSerenity.driver);
	}

	@Given("^provide some input to calculator$")
	public void provide_some_input_to_calculator() {
		System.out.println("SKIPPED: some input to calc");
	}

	@Then("^clear the screen and check the screen$")
	public void clear_the_screen_and_check_the_screen() {
		System.out.println("SKIPPED: clear screen");
	}
}
