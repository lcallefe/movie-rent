package steps;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FirstFeatureSteps {
	
	private int count = 0;
	
	@Given("^my count value is (\\d+)$")
	public void my_count_value_is(int value) throws Throwable {
		count = value;
	}

	@When("^I increase it by (\\d+)$")
	public void i_increase_it_by(int sum) throws Throwable {
		count += sum;

	}

	@Then("^the new value is (\\d+)$")
	public void the_new_value_is(int finalValue) throws Throwable {
		assertEquals(finalValue, count);
	
	}

}
