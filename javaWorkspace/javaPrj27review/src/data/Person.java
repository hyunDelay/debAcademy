package data;

public class Person {
	
	// 기본 생성자 (파라미터X, JVM이 자동으로 만들어줌)
	public Person() {
		
	}
	
	// 멤버 변수
	private String name;
	private int age; // 음수 ㄴㄴ, 기존보다 작게 ㄴㄴ
	private char gender; // M, F
	
	// 멤버 메소드
	public void breath() {
		System.out.println("숨쉬는중");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length() < 2) {
			System.out.println("2글자보다 작습니다.");
		} else {
			this.name = name;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 0 || age < this.age) {
			System.out.println("잘못된 값입니다.");
		} else {
			this.age = age;
		}
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if(gender == 'M' || gender == 'F') {
			this.gender = gender;
		} else {
			System.out.println("성별을 확인바랍니다.");
		}
	}
	
	// 객체 안의 모든 멤버변수(필드)를 출력하는 메소드
	public void printField() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
		System.out.println("성별 : " + this.gender);
	}
	public String getFieldInfo() {
		return "이름 : " + this.name + "\n나이 : " + this.age + "\n성별 : " + this.gender;
	}

}
