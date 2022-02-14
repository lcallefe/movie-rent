package entities;

import java.time.LocalDateTime;

public class RentService {
	
	RentInvoice invoice = new RentInvoice();
	LocalDateTime currentDate = LocalDateTime.now();

	public RentInvoice rent(Movie movie, RentType type) {
		validateStockIsNotEmpty(movie);
		validateTypeAndApplyBusinessRules(movie, type);	
		movie.setStock(movie.getStock()-1);
		return invoice;
	}
	
	public void validateStockIsNotEmpty(Movie movie) {
		if (movie.getStock() == 0)
			throw new RuntimeException("no stock");
	}
	
	public void validateTypeAndApplyBusinessRules(Movie movie, RentType type) {
		switch (type) {
		case NORMAL:
			invoice.setPrice(movie.getPrice());
			invoice.setReturnDate(currentDate.plusDays(1));
		break;
		case EXTENDED:
			invoice.setPrice(movie.getPrice()*2);
			invoice.setReturnDate(currentDate.plusDays(3));
		break;
		}

	}
		
}
