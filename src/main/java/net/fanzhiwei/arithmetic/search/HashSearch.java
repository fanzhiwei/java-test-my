package net.fanzhiwei.arithmetic.search;

import java.util.Arrays;

public class HashSearch {
	// “除法取余法”
	public static int hashLength = 13;

	// 原数据
	public static int[] array = { 13, 29, 27, 28, 26, 30, 38,43 };
	// 哈希表长度
	// java不支持越界，所以加13个开放地址，测试 使用
	public static int[] hash = new int[hashLength + 13];

	public static void insertHash(int[] hash, int hashLength, int data) {
		// 哈希函数
		int hashAddress = data % 13;

		// 如果key存在，则说明已经被别人占用，此时必须解决冲突
		while (hash[hashAddress] != 0) {
			hashAddress = (++hashAddress) % hashLength + 13;
		}

		// 将data存入字典中
		hash[hashAddress] = data;
	}

	public static int searchHash(int[] hash, int hashLength, int data) {
		// 哈希函数
		int hashAddress = data % hashLength;

		// 指定hashAdrress对应值存在但不是关键值，则用开放寻址法解决
		while (hash[hashAddress] != 0 && hash[hashAddress] != data) {
			hashAddress = (++hashAddress) % hashLength + 13;
		}

		// 查找到了开放单元，表示查找失败
		if (hash[hashAddress] == 0)
			return -1;
		return hashAddress;
	}

	public static void main(String[] args) {
		// 创建hash
		for (int i = 0; i < array.length; i++) {
			insertHash(hash, hashLength, array[i]);
		}
		
		System.out.println("Hash数据：" + Arrays.toString(hash));
	}
}
