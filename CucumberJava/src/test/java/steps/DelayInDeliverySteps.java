package steps;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import converters.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DelayInDeliverySteps {
	
	Date delivery = new Date();
	
	//@Transform vai converter a string recebida pruma data
	@Given("^the delivery time is (.*)$")
	public void theDeliveryTimeIs(@Transform(DateConverter.class) Date date) throws Throwable {
	    delivery = date;
	    
	}

	@When("^the delivery delays in (\\d+) (day|days|month|months)$")
	public void theDeliveryDelaysIn(int day_or_month, String time) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(delivery);
		if (time.equalsIgnoreCase("days") || time.equalsIgnoreCase("day"))
			cal.add(Calendar.DAY_OF_MONTH, day_or_month);
		else
			cal.add(Calendar.MONTH, day_or_month); //will add months instead of days
		delivery = cal.getTime();

	}

	@Then("^the delivery will occur in (.*)$")
	public void theDeliveryWillOccurIn(@Transform(DateConverter.class) Date date) {
		assertEquals(date, delivery);
		   
	}

}
