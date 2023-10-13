package car;

public abstract class Car {
	
	protected int price;
	protected String color;
	protected int speed;

	public abstract void go();
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public String toString() {
		return "스피드 : " + this.speed + "Km, 가격 : " + this.price + "원, 색깔 : " + this.color + "색";
	}
	
}
