package main;

import practice.ArrayTest;
import practice.ControlTest;
import practice.MethodTest;
import practice.OperatorTest;
import practice.VarTest;

public class Main {

	public static void main(String[] args) {
		
//		System.out.println("복습");
//		
//		VarTest vt = new VarTest();
//		vt.test();
//		
//		OperatorTest ot = new OperatorTest();
//		ot.test();
//		
//		ControlTest ct = new ControlTest();
//		ct.test();
//		
//		ArrayTest at = new ArrayTest();
//		at.test();
		
		MethodTest mt = new MethodTest();
		mt.test();
		mt.test01(777);
		mt.test02(43, 55);
		mt.test03();
		int num = mt.test04(30, 30);
		System.out.println(mt.test04(30, 30));
		System.out.println(num);

	}

}
