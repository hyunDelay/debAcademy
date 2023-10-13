package menu;

public class Menu {

	
	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String name;
	private int price;
	

	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + "]";
	}

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
	
	
	
	
}
