package com.chzero.algorithm.assemblage;

import java.util.Arrays;

/**
 * (最好使用此种)路径压缩, find节点的时候, 把节点的层数减少, 跨度为2(也可以指定其他跨度)
 *
 * 让层数少的节点指向层数多的节点, 记录新的层数
 * @author : CHZERO
 * @date   : 2019-03-27 11:36:12
 * @email  : 827348260@qq.com
 * @description : 并查集的时间复杂度近乎为O(1)
 */
public class UnionFind5 {

	private int[] arr;
	private int[] rank; // 节点的层数
	private int   count;

	public UnionFind5(int count) {
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
		while (index != arr[index]) {
			arr[index] = arr[arr[index]]; //让给点节点的上级节点变成当前节点的上级的上级, 如果是根节点 也只是重新赋值了一次根节点.
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

		//层数少的挂到层数多的根节点上
		if (this.rank[idA] < this.rank[idB]) {
			arr[idA] = arr[idB];
		} else if(this.rank[idA] > this.rank[idB]){
			arr[idB] = arr[idA];
		}else { //仅当层数相同时, 随挂随都行, 层数加一
			arr[idA] = arr[idB];
			rank[idB]++;
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(arr) + "\n" + Arrays.toString(rank);
	}

	public static void main(String[] args) {
		UnionFind5 unionFind = new UnionFind5(10);
		int i = unionFind.find(7);
		System.out.println(i);
		System.out.println(unionFind);
		System.out.println(unionFind.isConnected(7, 8));
		unionFind.unionElement(7, 8);

		System.out.println(unionFind.isConnected(7, 8));
		System.out.println(unionFind);
	}

}
