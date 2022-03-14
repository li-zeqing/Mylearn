package com.mylove.exer;
/**
 * 
 * @Description
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月14日下午11:14:39
 *
 */
public class Person {
	
	String name;
	int age;
	/**
	 * sex = 1表示男性
	 * sex = 0表示女性
	 */
	int sex;
	
	public void study() {
		System.out.println("studying");
	}
	
	public void showAge() {
		System.out.println("age:" + age);
	}
	
	public int addAge(int i) {
		return age + i;
	}
}
