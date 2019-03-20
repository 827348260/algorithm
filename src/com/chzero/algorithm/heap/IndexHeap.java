package com.chzero.algorithm.heap;

import com.chzero.algorithm.base.SortTestHelper;

import java.util.Arrays;

/**
 * 索引堆, 元素索引位置不变, 对元素的索引在另一个数组中进行堆排序
 * @author : CHZERO
 * @date   : 2019-03-13 11:49:44
 * @email  : 827348260@qq.com
 * @description : 提高元素的交换速率, 保证元素原始位置不变.
 */
public class IndexHeap {


	private int[] data;
	private int[] indexes;
	private int   count;
	private int   capacity;

	public IndexHeap() { }

	public IndexHeap(int capacity) {
		this.data = new int[capacity + 1];
		this.indexes = new int[capacity + 1];
		this.count = 0;
		this.capacity = capacity;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void insert(int index, int number) {
		assert (count + 1 <= capacity);
		assert (index + 1 >= 1 && index + 1 <= capacity);

		index++;
		this.data[index] = number;
		this.indexes[this.count + 1] = index;
		this.count++;
		this.shiftUp(count);

	}

	public int extractMax() {
		assert (count > 0);
		int ret = data[indexes[1]];

		SortTestHelper.swap(this.indexes, indexes[1], indexes[count]);
		//this.data[1] = this.data[count];  //把最后一个值移动到根节点
		count--; //丢掉最后一个值
		shiftDown(1); //对新的根节点值 寻找合适的位置

		return ret;
	}

	//获取最大值的索引
	public int extractMaxIndex() {
		assert (count > 0);
		int ret = indexes[1] - 1;

		SortTestHelper.swap(this.indexes, indexes[1], indexes[count]);
		//this.data[1] = this.data[count];  //把最后一个值移动到根节点
		count--; //丢掉最后一个值
		shiftDown(1); //对新的根节点值 寻找合适的位置

		return ret;
	}

	//根据索引 获取索引值
	public int getValue(int index){
		return this.data[index + 1];
	}

	//改变堆中某个元素的值, 需要对该值重新安排合适的位置
	public void change(int index, int value){
		index++;//实际索引比传入索引大1  0开始和1开始的区别
		this.data[index] = value;
		//找到data对应的indexes位置
		for (int i=1; i<= count; i++){
			if (indexes[i] == index){
				this.shiftUp(i);
				this.shiftDown(i);
				return;
			}
		}
	}





	private void shiftUp(int index) {
		while (index > 1 && data[this.indexes[index / 2]] < data[indexes[index]]) {
			SortTestHelper.swap(this.indexes, index / 2, index);
			index /= 2;
		}
	}

	private void shiftDown(int index) {
		while (2 * index <= count) {
			int j = 2 * index; // 在此轮循环中,data[k]和data[j]交换位置
			if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]]) { j++; }
			// data[j] 是 data[2*k]和data[2*k+1]中的最大值

			if (data[indexes[index]] >= data[indexes[j]]) { break; }
			SortTestHelper.swap(this.indexes, index, j);
			index = j;
		}

	}

	@Override
	public String toString() {
		return  "原始数据: " + Arrays.toString(data) + "\n"
				+ "索引: " + Arrays.toString(indexes);
	}

	public static void main(String[] args) {
		int[] arr = {76, 75, 86, 69, 45, 13, 62, 18, 69, 7};
		IndexHeap indexHeap = new IndexHeap(arr.length);
		for (int i = 0; i < arr.length; i++) {
			indexHeap.insert(i,arr[i]);
		}

		//原始数据: [0, 86, 75, 76, 69, 45, 7, 62, 18, 69, 13]
		//索引: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

		//System.out.println(indexHeap.toString());

		for (int i = 0; i < arr.length; i++) {
			System.out.println(indexHeap.extractMax());
		}

	}


}
