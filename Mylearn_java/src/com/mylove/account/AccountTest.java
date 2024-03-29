package com.mylove.account;
/**
 * 
 * @Description 银行账户测试类
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月19日下午9:13:40
 * 
 * 写一个用户程序测试Account类。在用户程序中，
 * 创建一个账户为1122、余额为20000、年利率4.5%的Account对象。
 * 使用withdraw方法提款30000元，并打印余额。
 * 在使用withdraw方法提款2500元。
 * 使用deposit方法存款3000元，然后打印余额和月利率。
 */
public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account(1122, 20000, 0.045);
		
		account.withdraw(30000);
		System.out.println("您的账户余额为：" + account.getBalance());
		account.withdraw(2500);
		System.out.println("您的账户余额为：" + account.getBalance());
		account.deposit(3000);
		System.out.println("您的账户余额为：" + account.getBalance());
		
		System.out.println("月利率为：" + (account.getMonthlyIneterst() * 100) + "%");
		
	}

}
