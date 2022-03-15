package com.mylove.exer;

public class Exer3Test {
	public static void main(String[] args) {
		Exer3Test test = new Exer3Test();
		
		test.method();
		
	}
	
	public void method() {
		for(int i = 0;i < 10;i++) {
			for(int j = 0;j < 8;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
