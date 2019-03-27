package com.chzero.algorithm.binary_bearch;

/**
 * 二分查找法  可以循环实现和递归实现(性能较差)
 * @author : CHZERO
 * @date   : 2019-03-20 09:24:51
 * @email  : 827348260@qq.com
 * @description : 基于有序数列进行查找, 找到对应的值返回index, 未找到返回-1
 *
 * bug-1:  int midIndex = (leftIndex + rightIndex) / 2; 当 leftIndex和rightIndex过大时, 会发生溢出bug.
 *
 */
public class BinarySearch {

	public int binarySearch(int[] arr, int n, int target) {
		int leftIndex = 0; //左边界
		int rightIndex = n - 1; //右边界

		while (leftIndex <= rightIndex) {
			//int midIndex = (leftIndex + rightIndex) / 2; //中间值索引
			int midIndex = leftIndex + (rightIndex - leftIndex) / 2; //中间值索引(***正确写法, 防止溢出***)
			if (arr[midIndex] == target) {
				return midIndex; //当中间值等于查询值, 直接返回结果
			}

			if (arr[midIndex] > target) { //当查询值小于中间值, 继续查询左区间
				rightIndex = midIndex - 1;
			} else { //当查询值大于中间值, 继续查询右区间
				leftIndex = midIndex + 1;
			}
		}
		return -1;
	}


}
