package com.mylove.exer;

public class Test {
	public static void main(String[] args) {
		int i = 1;
		i = i++ - ++i;
		System.out.println("  i = " + i);
	}
}
/*
 * i = i++;
 * a = i++;
 * 
 * temp = i, i = i + 1, temp执行表达式;
 * i = i + 1, temp = i, temp执行表达式
 * */
