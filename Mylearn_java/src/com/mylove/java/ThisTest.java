package com.mylove.java;
/**
 * 
 * @Description this关键字的使用
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月17日上午9:49:31
 *
 */
public class ThisTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		
		p1.setName("Tom");
		p1.setAge(18);
		System.out.println("name = " + p1.getName() + " age = " + p1.getAge());
	}
}

class Person{
	
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}
