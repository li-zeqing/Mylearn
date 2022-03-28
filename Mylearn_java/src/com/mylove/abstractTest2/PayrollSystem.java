package com.mylove.abstractTest2;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 
 * @Description 测试类
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月26日下午12:43:35
 * 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用
 * 利用循环结构遍历数组元素，输出各个对象的类型，name，number，birthday；
 * 当键盘输入本月份数值时，如果本月是某个Employee对象的生日，还要输出额外奖励100元信息
 */
public class PayrollSystem {
	public static void main(String[] args) {
		//输入月份数值
		//方式一：
//		Scanner scan = new Scanner(System.in);
//		System.out.println("请输入当前月份：");
//		int month = scan.nextInt();
		
		//方式二：
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);//获取当前月份 一月份：0
		
		
		
		Employee[] emps = new Employee[2];
		
		emps[0] = new SalariedEmployee("马森", 1002, new MyDate(1991, 2, 28),12000);
		
		emps[1] = new HourlyEmployee("李四", 1003, new MyDate(1992, 2, 6),60,240);
		
		for (int i = 0;i < emps.length;i++) {
			System.out.println(emps[i]);
			double salary = emps[i].earnings();
			System.out.println("月工资为：" + salary);
			if (month == emps[i].getBirthday().getMonth()) {
				System.out.println("生日快乐！奖励100元");
			}
		}
	}
}