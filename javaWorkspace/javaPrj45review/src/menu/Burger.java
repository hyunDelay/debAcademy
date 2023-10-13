package menu;

public class Burger {
	
	public Burger(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public Burger() {

	}
	
	private String name;
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Burger [name=" + name + ", price=" + price + "]";
	}
	
}
