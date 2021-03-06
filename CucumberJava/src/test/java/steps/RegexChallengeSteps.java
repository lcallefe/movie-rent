package steps;

import java.util.Date;

import converters.DateConverter;
import converters.DoubleConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegexChallengeSteps {
	
	String ticket;
	
	@Given("^the( special)? ticket is (A.\\d{3})$")
	public void theTicketIs(String type, String arg1) {
	
	}
	
	@And("^the ticket price is R\\$(.*)$")
	public void the_ticket_price_is_R$(@Transform(DoubleConverter.class) Double price) {

	}

	@And("^the passenger name is \"(.{5,20})\"$")
	public void the_passenger_name_is(String string) {

	}

	@And("^the passenger's cellphone number is (9\\d{4}-\\d{4})$")
	public void the_passenger_s_cellphone_number_is(String phoneNumber) {

	}

	@When("^I create the steps$")
	public void i_create_the_steps() {

	}

	@Then("^the test will pass$")
	public void the_test_will_pass() {

	}

}
