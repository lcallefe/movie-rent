package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.Movie;
import entities.RentInvoice;
import entities.RentService;
import entities.RentType;

public class MovieRentSteps {
	
	private Movie movie;
	private RentService rent = new RentService();
	private RentInvoice invoice;
	private String error;
	private RentType rentType = RentType.NORMAL;
	private LocalDateTime currentDate = LocalDateTime.now();

	@Given("^a movie$")
	public void a_movie(DataTable table) throws Throwable {
		Map<String, String> map = table.asMap(String.class, String.class);
		movie = new Movie();
		movie.setStock(Integer.parseInt(map.get("stock")));
		String type = map.get("type");
		movie.setPrice(Double.parseDouble(map.get("price")));
		rentType = type.equals("normal") ? RentType.NORMAL : RentType.EXTENDED;
	}
	
	@Given("^a movie stock with (\\d+) units$")
	public void aMovieStockWithUnits(int arg1) throws Throwable {
		movie = new Movie();
		movie.setStock(arg1);
		
	}

	@Given("^the rent price is R\\$(\\d+)$")
	public void theRentPriceIs(Double arg1) throws Throwable {
		movie.setPrice(arg1);
	}
	
	@Given("^the rent type is extended$")
	public void the_rent_type_is_extended() throws Throwable {
	    rentType = RentType.EXTENDED;
	}
	
	@Given("^the rent type is normal$")
	public void the_rent_type_is_normal() throws Throwable {
	}

	@When("^I rent one of the movies$")
	public void rentOneMovie() throws Throwable {
		try {
			invoice = rent.rent(movie, rentType);
		}catch (RuntimeException e) {
			error = e.getMessage();
		}
		
	}

	@Then("^the rent price will be R\\$(\\d+)$")
	public void rentPrice(Double arg1) throws Throwable {
		assertEquals(arg1, invoice.getPrice());
	}

	@Then("^the return date will be in the following day$")
	public void returnDatePlusOne() throws Throwable {
		assertEquals(1, invoice.getReturnDate().compareTo(currentDate));
		
	}
	
	@Then("^the return date will be in (\\d+) days$")
	public void returnDateWillBeInDays(int arg1) throws Throwable {
		assertEquals(arg1, invoice.getReturnDate().compareTo(currentDate));
	}

	@Then("^the stock will have a balance of (\\d+)$")
	public void stockWillHaveABalanceOf(int arg1) throws Throwable {
		assertEquals(arg1, movie.getStock());
	}
	
	@Then("^it will not be possible because theres no stock$")
	public void it_will_not_be_possible_because_theres_no_stock() throws Throwable {
		assertNotNull(error);
	}
	
	@Then("^the points earned will be equal to (\\d+)$")
	public void the_points_earned_will_be_equal_to(int arg1) throws Throwable {
	}
	
	

}
