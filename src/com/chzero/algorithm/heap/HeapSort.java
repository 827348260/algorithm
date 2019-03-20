package com.chzero.algorithm.heap;

import com.chzero.algorithm.base.SortTestHelper;

import java.util.Arrays;

/**
 * @author  : CHZERO
 * @date    : 2018-06-24 15:25
 * @email   : 827348260@qq.com
 * @description : 通过最大堆实现 从小到大, 从大到小的 排序
 */
public class HeapSort {

	public static void main(String[] args) {

/*		MaxHeap maxHeap = new MaxHeap(10);
		//Random random = new Random();
		int[] arr1 = {86, 75, 76, 69, 45, 7, 62, 18, 69, 13};
		for (int i = 0; i < 10; i++) {
			maxHeap.insert(arr1[i]);
		}
		System.out.println(maxHeap.toString());*/

		//获取从大到小的值
/*        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = maxHeap.extractMax();
        }
        System.out.println(Arrays.toString(arr));*/


		//获取从小到大的值
/*		int[] arr = new int[10];
		for (int i = 9; i >= 0; i--) {
			arr[i] = maxHeap.extractMax();
		}
		System.out.println(Arrays.toString(arr));*/


		//优化堆排序, 不需要开辟额外的空间, 直接在原数组上进行堆排序
		int[] arr2 = {76, 69, 45, 7, 62, 86, 75, 18, 69, 13};
		sort(arr2, arr2.length);

	}

	//索引从0开始, 父节点: (i-1)/2 左子节点: 2*i+1     右子节点: 2*i+2  最后一个非叶子节点: (count-1)/2
	private static void sort(int[] arr, int length) {
		//此循环将数组变成了最大堆的格式
		for (int i = (length - 1) / 2; i >= 0; i--) {
			shiftDown(arr, length, i);
		}
		System.out.println("数组变化为最大堆格式: " + Arrays.toString(arr));

		//把第一个值(最大值) 与堆的最后一个值交换.
		for (int i = length - 1; i > 0; i--) {
			SortTestHelper.swap(arr, 0, i); //交换
			shiftDown(arr, i, 0); // 交换后, 当前堆数据量-1. 然后对新的堆的根节点值值找合适的位置
		}
		System.out.println("原数组排序:" + Arrays.toString(arr));
		System.out.print("倒序:");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + ", ");
		}
	}

	//左子节点: 2*i+1      右子节点: 2*i+2
	private static void shiftDown(int[] arr, int length, int index) {
		while (2 * index + 1 < length) { //索引从0开始的 左子节点
			int maxKey = 2 * index + 1;

			if (maxKey + 1 < length && arr[maxKey + 1] > arr[maxKey]) { maxKey++; }
			// data[maxKey] 是 data[2 * index + 1]和data[2 * index + 2]中的最大值

			if (arr[index] >= arr[maxKey]) { break; }
			SortTestHelper.swap(arr, index, maxKey);
			index = maxKey;
		}
	}


}
