package com.mylove.abstractTest2;
/**
 * 
 * @Description
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月26日上午11:10:44
 * MyDate类包含：
 * private成员变量year，month，day；
 * toDateString()方法返回日期对象的字符串：xxxx年xxyuexxri
 * 
 */
public class MyDate {
	
	private int year;
	private int month;
	private int day;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String toDateString() {
		return year + "年" + month + "月" + day + "日";
	}
}
