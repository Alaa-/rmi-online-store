

import java.io.Serializable;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 1953176897064823857L;
	
	private final String type;
	private final String id;
	private final double price;

	public Product(String type, String id, double price) {
		this.type = type;
		this.id = id;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return this.id;
	}

	public double getPrice() {
		return this.price;
	}
	
	public boolean isBetterOfferThan(Product product) {
		if (product == null) {
			return true;
		}
		
		return this.getPrice() < product.getPrice();
	}
	
	public boolean isTypeOf(String type) {
		if (type == null) {
			return false;
		}
		return this.getType().equals(type);
	}

	public boolean equals(Object o) {
		if (o instanceof Product) {
			Product p = (Product) o;
			return type.equals(p.type) && id.equals(p.id);
		} else
			return false;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ", type: " + type + ", price: " + price;
				
	}
}