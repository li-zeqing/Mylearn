package com.mylove.abstractTest2;
/**
 * 
 * @Description 按小时计算工资
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月26日下午12:35:45
 * 参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的员工处理，该类包括：
 * private成员变量wage和hour；
 * 实现父类的抽象方法earnings()，该方法返回wage*hour值；
 * toString()方法输出员工类型信息及员工的name，number，birthday；
 */
public class HourlyEmployee extends Employee{
	
	private int wage;//每小时工资
	private int hour;//月工作时长
	public HourlyEmployee(String name, int number, MyDate birthday) {
		super(name, number, birthday);
		
	}
	
	public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
		super(name, number, birthday);
		this.wage = wage;
		this.hour = hour;
	}
	

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public double earnings() {
		return wage * hour;
	}

	@Override
	public String toString() {
		
		return "HourlyEmployee[" + super.toString() + "]";
	}
	
}
