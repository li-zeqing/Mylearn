package com.mylove.team.service;
import static com.mylove.team.service.Data.*;

import com.mylove.team.domain.Architect;
import com.mylove.team.domain.Designer;
import com.mylove.team.domain.Employee;
import com.mylove.team.domain.Equipment;
import com.mylove.team.domain.NoteBook;
import com.mylove.team.domain.PC;
import com.mylove.team.domain.Printer;
import com.mylove.team.domain.Programmer;

/**
 * 
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]方法。
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月30日下午6:45:28
 *
 */
public class NameListService {
	private Employee[] employees;
	
	/**
	 * 给employees及数组元素进行初始化
	 */
	public NameListService() {
		/*
		 * 根据项目提供的Data类构建相应大小的employees数组
		 * 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，
		 * 以及相关联的Equipment子类的对象，将对象存于数组中
		 */
		employees = new Employee[EMPLOYEES.length];
		for (int i = 0; i < employees.length; i++ ) {
			//获取员工的类型
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			//获取Employee的4个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;
			
			//构造相应的对象
			switch (type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			
			
			}
		}
		
		
	}
	/**
	 * 
	 *@Description  获取员工设备
	 *@author Zeqing Li
	 *@date 2022年3月30日下午7:10:18 
	 *@param i
	 *@return
	 */
	private Equipment createEquipment(int index) {
		
		int key = Integer.parseInt(EQUIPMENTS[index][0]);
		
		String modelOrName = EQUIPMENTS[index][1];
		switch(key) {
		case PC:
			String display = EQUIPMENTS[index][2];
			return new PC(modelOrName,display);
		
		case NOTEBOOK:
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(modelOrName, price);
			
		case PRINTER:
			String type = EQUIPMENTS[index][2];
			return new Printer(modelOrName, type);
		
		}
		
		return null;
	}
	/**
	 * 
	 *@Description 获取所有员工对象的数组
	 *@author Zeqing Li
	 *@date 2022年3月30日下午7:35:40 
	 *@return
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}
	/**
	 * 
	 *@Description 获取指定ID的员工对象
	 *@author Zeqing Li
	 *@date 2022年3月30日下午7:36:07 
	 *@param id
	 *@return
	 */
	public Employee getEmployee(int id) throws TeamException{
		for (int i = 0; i < employees.length;i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		
		throw new TeamException("找不到指定的员工");
	}
}

