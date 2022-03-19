package com.mylove.account;
/**
 * 
 * @Description 银行账户类
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月19日下午9:13:15
 *
 */
public class Account {
	private int id;//账户
	private double balance;//余额
	private double annualInterestRate;//年利率
	public Account(int id, double balance, double annualInterestRate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	//获取月利率
	public double getMonthlyIneterst() {
		return annualInterestRate / 12;
	}
	//取钱
	public void withdraw(double amount) {
		if(balance >= amount) {
			balance -= amount;
		}else {
			System.out.println("余额不足");
		}
	}
	//存钱
	public void deposit(double amount) {
		if(amount >0) {
			balance += amount;
		}else {
			System.out.println("存钱失败");
		}
	}
}
