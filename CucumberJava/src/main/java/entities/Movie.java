package entities;


public class Movie {
	
	private int stock;
	private Double price;

	
	public void setStock(int arg1) {
		this.stock = arg1;
		
	}
	
	public int getStock() {
		return stock;
	}

	public void setPrice(Double arg1) {
		this.price = arg1;
		
	}

	public Double getPrice() {
		return price;
	}
	

}