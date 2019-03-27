package com.chzero.algorithm.assemblage;

import java.util.Arrays;

/**
 * 让节点数少的节点指向节点数多的节点, 记录新的节点数
 * @author : CHZERO
 * @date   : 2019-03-27 11:36:12
 * @email  : 827348260@qq.com
 * @description : 并查集的时间复杂度近乎为O(1)
 */
public class UnionFind3 {

	private int[] arr;
	private int[] size; // 节点的子节点数
	private int   count;

	public UnionFind3(int count) {
		this.arr = new int[count];
		this.size = new int[count];
		this.count = count;

		for (int i = 0; i < count; i++) {
			this.arr[i] = i;
			this.size[i] = 1;
		}
	}

	//给定一个节点, 返回他的根节点
	public int find(int index) {
		assert (index >= 0 && index < this.count);
		while (index != arr[index]) {
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

		//节点数少的挂到节点数多的根节点上
		if (this.size[idA] < this.size[idB]) {
			arr[idA] = arr[idB];
			//改变大小
			this.size[idB] += this.size[idA];
		} else {
			arr[idB] = arr[idA];
			this.size[idA] += this.size[idB];
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(arr) + "\n" + Arrays.toString(size);
	}

	public static void main(String[] args) {
		UnionFind3 unionFind = new UnionFind3(10);
		int i = unionFind.find(7);
		System.out.println(i);
		System.out.println(unionFind);
		System.out.println(unionFind.isConnected(7, 8));
		unionFind.unionElement(7, 8);

		System.out.println(unionFind.isConnected(7, 8));
		System.out.println(unionFind);
	}

}
