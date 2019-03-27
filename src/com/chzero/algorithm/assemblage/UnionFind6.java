package com.chzero.algorithm.assemblage;

import java.util.Arrays;

/**
 * (递归实现比层数压缩运行效率低, 所有最佳的实践是层数压缩)路径压缩, 把所有的子节点都指向根节点, 层数为1
 *
 * 让层数少的节点指向层数多的节点, 记录新的层数
 * @author : CHZERO
 * @date   : 2019-03-27 11:36:12
 * @email  : 827348260@qq.com
 * @description : 并查集的时间复杂度近乎为O(1)
 */
public class UnionFind6 {

	private int[] arr;
	private int[] rank; // 节点的层数
	private int   count;

	public UnionFind6(int count) {
		this.arr = new int[count];
		this.rank = new int[count];
		this.count = count;

		for (int i = 0; i < count; i++) {
			this.arr[i] = i;
			this.rank[i] = 1;
		}
	}

	//给定一个节点, 返回他的根节点, 自己的父节点是自己则代表找到了根节点
	public int find(int index) {
		assert (index >= 0 && index < this.count);

		if (index != arr[index]) {
			arr[index] = this.find(arr[index]); //一直递归到根节点, 最后所有节点的父节点都是根节点.
		}
		return arr[index];
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

		//层数少的挂到层数多的根节点上
		if (this.rank[idA] < this.rank[idB]) {
			arr[idA] = arr[idB];
		} else if (this.rank[idA] > this.rank[idB]) {
			arr[idB] = arr[idA];
		} else { //仅当层数相同时, 随挂随都行, 层数加一
			arr[idA] = arr[idB];
			rank[idB]++;
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(arr) + "\n" + Arrays.toString(rank);
	}

	public static void main(String[] args) {
		UnionFind6 unionFind = new UnionFind6(10);
		int i = unionFind.find(7);
		System.out.println(i);
		System.out.println(unionFind);
		System.out.println(unionFind.isConnected(7, 8));
		unionFind.unionElement(7, 8);

		System.out.println(unionFind.isConnected(7, 8));
		System.out.println(unionFind);
	}

}
