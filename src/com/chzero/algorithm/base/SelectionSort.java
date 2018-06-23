package com.chzero.algorithm.base;

import java.util.Arrays;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-22 11:33
 * @email 827348260@qq.com
 * @description 选择排序法 - Selection Sort O(n^2)
 */
public class SelectionSort{

    public static void selectionSort(int[] arr, int count){
        for (int i = 0; i < count; i++){
            //寻找索引[i,n)区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < count; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            SortTestHelper.swap(arr, i, minIndex);
        }
    }


    public static void main(String[] args){
        int number = 1000;
        int[] array = SortTestHelper.generateRandomArray(number, 0, number);
        System.out.println("排序前 : " + Arrays.toString(array));
        selectionSort(array, number);
        System.out.println("排序后 : " + Arrays.toString(array));
    }


}
