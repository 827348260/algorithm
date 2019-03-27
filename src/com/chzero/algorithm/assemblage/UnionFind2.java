package com.chzero.algorithm.assemblage;

import java.util.Arrays;

/**
 * 并查集-链表
 * @author : CHZERO
 * @date   : 2019-03-27 11:18:53
 * @email  : 827348260@qq.com
 * @description : 并查集的时间复杂度近乎为O(1)
 */
public class UnionFind2 {

	private int[] arr;
	private int   count;

	public UnionFind2(int count) {
		this.arr = new int[count];
		this.count = count;

		for (int i = 0; i < count; i++) {
			this.arr[i] = i;
		}
	}

	//给定一个节点, 返回他的根节点
	public int find(int index) {
		assert (index >= 0 && index < this.count);
		while (index != arr[index]){
			index = arr[index];
		}
		return index;
	}

	//A,B 是否对应同一个根, 同根则代表连接在一起
	public boolean isConnected(int indexA, int indexB) {
		return this.find(indexA) == find(indexB);
	}

	//合并两个
	public void unionElement(int indexA, int indexB) {
		int idA = this.find(indexA); // 获取A的根
		int idB = this.find(indexB); // 获取B的根
		if (idA == idB) { //如果AB同根, 代表已经连接不需要再操作
			return;
		}
		arr[idB] = arr[idA]; //把后一个根节点的的根设置为前一个根
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {
		UnionFind2 unionFind = new UnionFind2(10);
		int i = unionFind.find(7);
		System.out.println(i);
		System.out.println(unionFind);
		System.out.println(unionFind.isConnected(7,8));
		unionFind.unionElement(7, 8);

		System.out.println(unionFind.isConnected(7,8));
		System.out.println(unionFind);
	}
}
