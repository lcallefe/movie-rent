package entities;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class RentInvoice {
	private Double price;
	private LocalDateTime returnDate;

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void setReturnDate (LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	
	public Double getPrice() {
		return price;
	}

}
