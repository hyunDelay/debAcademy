package main;

import car.Avante;
import car.Car;
import car.Lcid;
import car.Sonata;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("추상화");
		
		int n = 2;
		Car[] car = new Sonata[n];
		for(int i = 0; i < car.length; i++) {
			System.out.print("[ 소나타 ] ");
			car[i] = new Sonata();
			System.out.println(car[i]);
		}
		
//		Avante avante = new Avante();
//
//		sonata.setPrice(36000000);
//		sonata.setSpeed(300);
//		sonata.setColor("Gray");
//		sonata.go();
//		
//		avante.setPrice(28000000);
//		avante.setSpeed(200);
//		avante.setColor("White");
//		System.out.println(avante);
//		avante.go();
		
		Car lcid = new Lcid();
		lcid.go();
		
	}
	
}
