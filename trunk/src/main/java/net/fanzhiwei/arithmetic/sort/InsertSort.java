package net.fanzhiwei.arithmetic.sort;

import java.util.Arrays;

public class InsertSort {
	public static void insertSort(int[] array) {
		// 无序序列
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];

			int j;

			// 有序序列
			for (j = i - 1; j >= 0 && temp < array[j]; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
				98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
		insertSort(a);
		System.out.println(Arrays.toString(a));
	}
}
