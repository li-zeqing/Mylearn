package com.mylove.exer;
/**
 * 
 * @Description 自定义数据工具类
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月15日下午2:49:50
 *
 */
public class ArrayUtil {

	
	//求数组最大值
	public int getMax(int[] arr) {
		int maxvalue = arr[0];
		for(int i = 0;i < arr.length;i++) {
			if(maxvalue < arr[i]) {
				maxvalue = arr[i];
			}
		}
		return maxvalue;
	}
	//求数组最小值
	public int getMin(int[] arr) {
		int minvalue = arr[0];
		for(int i = 0;i < arr.length;i++) {
			if(minvalue > arr[i]) {
				minvalue = arr[i];
			}
		}
		return minvalue;
	}
	//求数组总和
	public int getSum(int[] arr) {
		int sum = 0;
		for(int i = 0;i < arr.length;i++) {
			sum += arr[i];
		}
		return sum;
	}
	//求数组平均值
	public double getMean(int[] arr) {
		
		return getSum(arr) / arr.length;
	}
	//反转数组
	public void reverse(int[] arr) {
		for(int i = 0,j = arr.length - 1;i<j;i++,j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
	}
	
	//复制数组
	public int[] copyArray(int[] arr) {
		int[] arr1 = new int[arr.length];
		for(int i = 0;i < arr.length;i++) {
			arr1[i] = arr[i];
		}
		return arr1;
	}
	
	//数组排序
	public void sortArray(int[] arr) {
		//冒泡排序
		for(int i = 0;i < arr.length-1;i++) {
			for(int j = 0;j < arr.length - 1 - i;j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1]  = temp;
				}
			}
		}
		
	}
	
	//遍历数组
	public void printArray(int[] arr) {
		for(int i = 0;i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}
	//查找指定元素
	public int getIndex(int[] arr,int dest) {
		for(int i = 0;i < arr.length;i++) {
			if(arr[i] == dest) {
				return i;
			}
		}
		return -1;
	}
}
