package main;

import car.Avante;
import hyundai.Cona;
import hyundai.Hyundai;

public class Main {

	public static void main(String[] args) {

		System.out.println("상속");
		
		Avante avante = new Avante();
		
		Cona cona = new Cona();
		cona.accel();
		cona.$break();
		
		System.out.println(cona.toString());
		
	}

}
