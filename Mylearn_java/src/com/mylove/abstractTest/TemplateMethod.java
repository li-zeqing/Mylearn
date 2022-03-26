package com.mylove.abstractTest;

/**
 * 
 * @Description 抽象类的应用：模板方法的设计模式
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月26日上午10:42:21
 *
 */
public class TemplateMethod {
	public static void main(String[] args) {
		SubTemplate t = new SubTemplate();
		t.spendTime();
	}
}

abstract class Template {
	// 计算某段代码运行所花费的时间
	public void spendTime() {

		long start = System.currentTimeMillis();

		code(); // 不确定的部分，易变的部分

		long end = System.currentTimeMillis();

		System.out.println("代码与运行的时间：" + (end - start));
	}

	public abstract void code(); // 抽象方法
}

class SubTemplate extends Template {

	@Override
	public void code() {
		// 求1000内的质数
		for (int i = 2; i <= 1000; i++) {
			boolean isFlag = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isFlag = false;
					break;
				}
			}
			if (isFlag) {
				System.out.println(i);
			}
		}
	}

}
