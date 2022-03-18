package com.mylove.cim.service;

import com.mylove.cim.bean.Customer;

/**
 * 
 * @Description CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 *              并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月18日上午9:59:08
 *
 */

public class CustomerList {
	private Customer[] customers;// 用来保存客户对象的数组
	private int total = 0;// 记录已保存客户对象的数量
	
	/**
	 * 用来初始化customer数组的构造器
	 * @param totalCustomer：指定数组的长度
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	
	/**
	 * 
	 *@Description 将指定的客户添加到数组中
	 *@author Zeqing Li
	 *@date 2022年3月18日下午8:32:10 
	 *@param customer
	 *@return true：添加成功 false：添加失败
	 */
	public boolean addCustomer(Customer customer) {
		if (total >= customers.length) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}
	
	/**
	 * 
	 *@Description 修改指定索引位置的客户信息
	 *@author Zeqing Li
	 *@date 2022年3月18日下午8:34:22 
	 *@param index
	 *@param cust
	 *@return true：修改成功 false：修改失败
	 */
	public boolean replaceCustomer(int index, Customer cust) {
		if (index < 0 || index >= total) {
			return false;
		}
		
		customers[index]  = cust;
		return true;
	}
	/**
	 * 
	 *@Description 删除指定索引位置上的客户信息
	 *@author Zeqing Li
	 *@date 2022年3月18日下午8:36:09 
	 *@param index
	 *@return true：删除成功 false：修改失败
	 */
	public boolean deleteCustomer(int index) {
		if ( index < 0 || index >= total) {
			return false;
		}
		for ( int i = index;i < total - 1;i++) {
			customers[i] = customers[i + 1];
		}
		//最后有数据的元素需要置空
		customers[--total] = null;
		return true;
	}
	
	/**
	 * 
	 *@Description 获取所有客户的信息
	 *@author Zeqing Li
	 *@date 2022年3月18日下午8:41:49 
	 *@return
	 */
	public Customer[] getAllCustomer() {
		Customer[] custs = new Customer[total];
		for(int i = 0;i < total;i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	
	/**
	 * 
	 *@Description 获取指定索引位置上的客户
	 *@author Zeqing Li
	 *@date 2022年3月18日下午8:44:09 
	 *@param index
	 *@return 如果找到则返回该元素 否则返回null
	 */
	public Customer getCustomer(int index) {
		if ( index < 0 || index >= total) {
			return null;
		}
		
		return customers[index];
	}
	
	/**
	 * 
	 *@Description 获取存储的客户的数量
	 *@author Zeqing Li
	 *@date 2022年3月18日下午8:46:51 
	 *@return
	 */
	public int getTotal() {
		return customers.length;
	}
}
