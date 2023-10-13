package hyundai;

public class Hyundai {
	
	String carName;
	int price;

	public void accel() {
		System.out.println("부아앙");
	}
	public void $break() {
		System.out.println("끼이익");
	}
	
	@Override
	public String toString() {
		return "Hyundai [carName=" + carName + ", price=" + price + "]";
	}
	
}
