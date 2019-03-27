package com.chzero.algorithm.assemblage;

import java.util.Arrays;

/**
 * 并查集
 * @author : CHZERO
 * @date   : 2019-03-27 10:07:38
 * @email  : 827348260@qq.com
 * @description : 并查集的时间复杂度近乎为O(1)
 */
public class UnionFind {

	private int[] arr;
	private int   count;

	public UnionFind(int count) {
		this.arr = new int[count];
		this.count = count;

		for (int i = 0; i < count; i++) {
			this.arr[i] = i;
		}
	}

	public int find(int index) {
		assert (index >= 0 && index < this.count);
		return this.arr[index];
	}

	public boolean isConnected(int indexA, int indexB) {
		return this.find(indexA) == find(indexB);
	}

	public void unionElement(int indexA, int indexB) {
		int idA = this.find(indexA);
		int idB = this.find(indexB);
		if (idA == idB) {
			return;
		}
		for (int i = 0; i < this.count; i++) {
			if (arr[i] == idA){
				arr[i] = idB;
			}
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {
		UnionFind unionFind = new UnionFind(10);
		int i = unionFind.find(7);
		System.out.println(i);
		System.out.println(unionFind);
		System.out.println(unionFind.isConnected(7,8));
		unionFind.unionElement(7, 8);

		System.out.println(unionFind.isConnected(7,8));
		System.out.println(unionFind);


	}


}
