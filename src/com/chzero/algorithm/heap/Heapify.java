package com.chzero.algorithm.heap;

/**
 * 把一个 数组转换成最大堆
 * @author : CHZERO
 * @date   : 2019-03-13 10:23:36
 * @email  : 827348260@qq.com
 * @description :
 */
public class Heapify {

	public static void main(String[] args) {
		int[] arr = {86, 75, 76, 69, 45, 7, 62, 18, 69, 13};
		MaxHeap maxHeap = new MaxHeap(arr, arr.length);
		System.out.println(maxHeap.toString());

		for (int i = arr.length; i >= 1; i--) {
			System.out.println(maxHeap.extractMax());
		}
	}

}
