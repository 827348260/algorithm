package com.chzero.algorithm.base;

import java.util.Arrays;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-22 12:58
 * @email 827348260@qq.com
 * @description 插入排序法 - Insertion Sort   找到合适的位置可终止内部循环, 然后插入元素到合适的位置  延伸出shell排序
 * 在需要排序的数据近乎有序时, 插入排序的效率非常的高(最高为O(n)) 最坏O(n^2)
 */
public class InsertionSort{

    public static void insertionSort(int[] arr, int left, int right){
        for (int i = left; i <= right; i++){
            //暂存需要插入的值
            int temp = arr[i];
            int j;
            //寻找元素arr[i]合适的插入位置
            for (j = i; j > 0 && arr[j - 1] > temp; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void insertionSort(int[] arr, int count){
        for (int i = 1; i < count; i++){
            //暂存需要插入的值
            int temp = arr[i];
            int j;
            //寻找元素arr[i]合适的插入位置
            for (j = i; j > 0 && arr[j - 1] > temp; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args){
        int number = 100;
        int[] array = SortTestHelper.generateRandomArray(number, 0, number);
        System.out.println("排序前 : " + Arrays.toString(array));
        insertionSort(array, number);
        System.out.println("排序后 : " + Arrays.toString(array));
    }

}
