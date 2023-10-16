package kh.model.vo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

public class Food {

	public Food() {
		
	}
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}
	
	private String name;
	private int kcal;
	
	public void fileSave(String fileName) throws Exception {
		File file = new File(fileName);
		PrintStream ps = new PrintStream(file);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Food food = new Food("사과", 20);
		oos.writeObject(food);
		
		//닫기
		ps.close();
		fos.close();
		oos.close();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	
	@Override
	public String toString() {
		return "Food [name=" + name + ", kcal=" + kcal + "]";
	}
	
}
