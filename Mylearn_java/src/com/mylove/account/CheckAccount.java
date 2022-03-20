package com.mylove.account;
/**
 * 
 * @Description 信用卡账户
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月20日上午8:31:46
 *
 */
public class CheckAccount extends Account{
	
	private double overdraft;//可透支额度
	
	public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft = overdraft;
	}
	
	
	public double getOverdraft() {
		return overdraft;
	}


	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}


	@Override
	public void withdraw(double amount) {
		if (getBalance() >= amount) {//余额就足够消费
			super.withdraw(amount);
		}else if(overdraft >= amount - getBalance()) {
			//透支额度+余额 足够消费
			overdraft -= amount - getBalance();
			super.withdraw(getBalance());//余额取光
		}else {
			System.out.println("超过可透支额度！");
		}
	}
	
	
}
