package com.mylove.bank;
/**
 * 
 * @Description bank测试
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月17日上午11:45:16
 *
 */
public class BankTest {
	public static void main(String[] args) {
		
		Bank bank = new Bank();
		
		bank.addCustomer("Jane","Smith");
		
		bank.getCustomer(0).setAccount(new Account(2000));
		
		bank.getCustomer(0).getAccount().withdraw(500);
		
		double balance = bank.getCustomer(0).getAccount().getBalance();
		System.out.println("客户：" + bank.getCustomer(0).getFirstName() + " 账户余额：" + balance);
	}
	
	
}
