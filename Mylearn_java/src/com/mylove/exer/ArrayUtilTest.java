package com.mylove.exer;

public class ArrayUtilTest {
	public static void main(String[] args) {
		ArrayUtil util = new ArrayUtil();
		int[] arr = new int[] {12,4,64,35,87,-5,67,-27,0,65,33,-55,98,201};
		
		int max = util.getMax(arr);
		System.out.println("最大值为：" + max);
		
		System.out.println("排序前：");
		util.printArray(arr);
		util.sortArray(arr);
		System.out.println("排序后：");
		util.printArray(arr);
		
		//查找指定元素
		System.out.println("查找：");
		int index = util.getIndex(arr, 4);
		if(index >= 0) {
			System.out.println("找到了，该元素在数组中的下标为" + index);
		}else {
			System.out.println("没找到");
		}
	}
}
