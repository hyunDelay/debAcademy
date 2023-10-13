package data;

public class Person {
	
	
	
//	// 생성자
//	public Person(String string, int i) {
//		this.name = "홍길동";
//		this.age = 22;
//	}
//	// 기본생성자
//	public Person() {
//		
//	}

	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void breath() {
		System.out.println("숨쉬는중");
	}

	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
