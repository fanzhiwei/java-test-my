package net.fanzhiwei.arithmetic.search;

public class Sequential {
	public static int sequenceSearch (int[] array,int value){
		
		for (int i = 0; i < array.length; i++ ){
			if(array[i] == value){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		int[] array = { 3, 7, 9, 10, 11, 24, 45, 66, 77 };
		int index = sequenceSearch(array,11);
		System.out.println(index);
	}
}
//顺序查找：
//
//这种非常简单，就是过一下数组，一个一个的比，找到为止。
