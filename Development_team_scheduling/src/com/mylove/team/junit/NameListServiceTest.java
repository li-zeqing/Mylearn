package com.mylove.team.junit;

import org.junit.jupiter.api.Test;

import com.mylove.team.domain.Employee;
import com.mylove.team.service.NameListService;
import com.mylove.team.service.TeamException;

/**
 * 
 * @Description 对NameListService类的测试
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月30日下午7:47:01
 *
 */
public class NameListServiceTest {
	
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for (int i = 0;i < employees.length;i++) {
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 1;
		id = 15;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			
			System.out.println(e.getMessage());;
		}
	}
}
