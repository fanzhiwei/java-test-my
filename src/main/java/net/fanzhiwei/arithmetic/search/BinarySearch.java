package net.fanzhiwei.arithmetic.search;

public class BinarySearch {
	public static int search(int[]array,int value){
		int low = 0;//最低限
		int high= array.length - 1;//最高限
		for (;low <= high;){
			int middle = (low + high)/2;
			if (array[middle] == value){
				return middle;
			}
			else if (value < array[middle]){
				high = middle -1;
			}
			else if (value > array[middle]){
				low = middle + 1 ;
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		int[] array = { 2,3, 7, 9, 10, 11, 24, 45, 66, 77 };
		int index = search(array,77);
		System.out.println(index);
	}
}
//折半查找: 这种查找很有意思，就是每次都砍掉一半，
//
//比如"幸运52“中的猜价格游戏，价格在999元以下，1分钟之内能猜到几样给几样，如果那些选手都知道折半查找，
//
//那结果是相当的啊。
//
//不过要注意，这种查找有两个缺点：
//
//第一： 数组必须有序，不是有序就必须让其有序，大家也知道最快的排序也是NLogN的，所以.....呜呜。
//
//第二： 这种查找只限于线性的顺序存储结构。
