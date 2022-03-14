package com.mylove.exer;
/**
 * 
 * @Description
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月14日下午11:09:30
 *
 */
public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		
		p1.name = "Tom";
		p1.age = 18;
		p1.sex = 1;
		
		p1.study();
		
		p1.showAge();
		
		
		int newAge = p1.addAge(2);
		System.out.println(p1.name + "的新年龄是：" + newAge);
		
	}
	
}
