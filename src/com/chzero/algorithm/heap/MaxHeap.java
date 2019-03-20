package com.chzero.algorithm.heap;

import com.chzero.algorithm.base.SortTestHelper;

import java.util.Arrays;

/**
 * @author  : CHZERO
 * @date    : 2018-06-24 15:25
 * @email   : 827348260@qq.com
 * @description : 堆 结构   二叉堆是一种完全二叉树; 堆中某节点的值总是不大于其父节点的值; 堆总是一颗完全二叉树(最大堆);
 */
public class MaxHeap {

	private int[] data;
	private int   count;
	private int   capacity;

	public MaxHeap() { }

	public MaxHeap(int capacity) {
		this.data = new int[capacity + 1];
		this.count = 0;
		this.capacity = capacity;
	}

	//Heapify 把数组转换成堆
	public MaxHeap(int[] arr, int length) {
		this.data = new int[length + 1];
		this.capacity = length;
		this.count = length;
		for (int i = 0; i < length; i++) {
			this.data[i + 1] = arr[i];
		}

		for (int i = this.count / 2; i >= 1; i--) {
			this.shiftDown(i);
		}

	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void insert(int number) {
		assert (count + 1 <= capacity); //插入一个值到堆中, 检查当茶插入位置的索引是否超过最大容量
		this.data[this.count + 1] = number;
		this.count++;
		this.shiftUp(count); //对新插入值, 摆正位置
	}

	//插入节点的父节点为 index/2
	private void shiftUp(int index) {
		while (index > 1 && data[index / 2] < data[index]) {
			SortTestHelper.swap(this.data, index / 2, index);
			index /= 2;
		}
	}

	public int extractMax() {
		assert (count > 0); //判断是否还有值

		int ret = data[1]; //最大堆的索引为1的值为最大值
		SortTestHelper.swap(this.data, 1, count); //将第一个值取出后, 和最后一个值交换顺序
		count--; //丢掉当前最后一个值
		shiftDown(1); //对新的根节点值 重新寻找合适的位置

		return ret;
	}

	//节点的子节点为    2*index(左)   和    2*index+1(右)
	private void shiftDown(int index) {
		while (2 * index <= count) { //判断是否存在左节点

			//比较左节点与右节点, 获取最大的那个节点
			int maxKey = 2 * index;
			//是否存在右节点, 左右节点比较取最大
			if (maxKey + 1 <= count && data[maxKey + 1] > data[maxKey]) { maxKey++; }
			// data[maxKey] 是 data[2*index]和data[2*index+1]中的最大值

			//用父节点和它的两个子节点中的最大的那个节点比较, 如果大于等于则代表找到了合适的位置,方法结束,
			if (data[index] >= data[maxKey]) { break; }
			SortTestHelper.swap(this.data, index, maxKey); //如果小于则交换
			index = maxKey; //交换后, 对交换的位置再次与子节点进行比较
		}

	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(6);
		maxHeap.insert(999);
		maxHeap.insert(333);
		maxHeap.insert(222);
		maxHeap.insert(555);
		maxHeap.insert(444);
		maxHeap.insert(0);
		System.out.println(maxHeap.toString());

		for (int i = 0; i < 6; i++) {
			int value = maxHeap.extractMax();
			System.out.println(value);
		}

	}


}
