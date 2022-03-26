package com.mylove.abstractTest2;
/**
 * 
 * @Description 
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月26日上午11:04:01
 *  定义一个Employee类：
 *  private成员变量name，number，birthday，其中birthday为MyDate类的对象
 *  abstract方法earnings()
 *  toString()方法输出对象的name，number和birthday
 */
public abstract class Employee {

	private String name;
	private int number;
	private MyDate birthday;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	
	
	public Employee(String name, int number, MyDate birthday) {
		super();
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}

	//抽象方法
	public abstract double earnings();

	@Override
	public String toString() {
		return "name=" + name + ", number=" + number + ", birthday=" + birthday.toDateString() + "]";
	}
	
	 
}
