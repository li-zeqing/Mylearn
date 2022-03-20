package com.mylove.account;
/**
 * 
 * @Description 信用卡账户测试类
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月20日上午8:48:43
 *
 */
public class CheckAccountTest {
	public static void main(String[] args) {
		
		CheckAccount acct = new CheckAccount(1122, 20000, 0.045, 5000);
		
		acct.withdraw(5000);
		System.out.println("您的账户余额为：" + acct.getBalance());
		System.out.println("您的可透支额度为：" + acct.getOverdraft());
		acct.withdraw(18000);
		System.out.println("您的账户余额为：" + acct.getBalance());
		System.out.println("您的可透支额度为：" + acct.getOverdraft());
		acct.withdraw(3000);
		System.out.println("您的账户余额为：" + acct.getBalance());
		System.out.println("您的可透支额度为：" + acct.getOverdraft());


		
	}
}
