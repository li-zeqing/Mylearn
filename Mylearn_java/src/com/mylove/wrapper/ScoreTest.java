package com.mylove.wrapper;
/**
 * 
 * @Description 包装类的学生成绩测试
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月22日上午10:41:35
 *
 */

import java.util.Scanner;
import java.util.Vector;

/*
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
 * 提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。
 * 而向量类java.util.Vector可以根据需要动态伸缩。
 * 
 * 创建Vector对象： Vector v = new Vector();
 * 给向量添加元素：v.addElement(Object obj);//obj必须是对象
 * 取出向量中的元素：Object obj = v.elementAt(0);
 * 注意第一个元素的下标是0，返回值是Object类型的。
 * 计算向量的长度：v.size();
 * 若与最高分相差10分内：A等级
 * 		  相差20分内：B等级
 *        相差30分内：C等级
 *             其他：D等级
 * 
 */
public class ScoreTest {
	public static void main(String[] args) {
		//实例化Scanner 
		Scanner scan = new Scanner(System.in);
		
		//创建Vector对象
		Vector v = new Vector();
		
		
		char level;
		int maxScore = 0;
		//循环输入学生成绩
		for (; ; ) {
			System.out.println("请输入学生成绩（以负数代表输入结束）：");
			int score = scan.nextInt();
			if (score < 0) {
				break;
			}
			if (score >100) {
				System.out.println("输入数据有误，请重新输入");
				continue;
			}
			v.addElement(score);
			
			if ( maxScore < score) {
				maxScore = score;
			}
		}
		//遍历Vector输出学生成绩和等级
		for (int i = 0;i < v.size();i++) {
			Object obj = v.elementAt(i);
			int intObj = (int)obj;
			if(maxScore - intObj <= 10) {
				level = 'A';
			}else if(maxScore - intObj <= 20) {
				level = 'B';
			}else if(maxScore - intObj <= 30) {
				level = 'C';
			}else {
				level = 'D';
			}
			System.out.println("student " + i + " score is " + intObj + " , level is " + level);
		}
	}
	
}
