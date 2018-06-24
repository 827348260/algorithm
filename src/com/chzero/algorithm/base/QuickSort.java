package com.chzero.algorithm.base;

import java.util.Arrays;
import java.util.Random;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-23 23:10
 * @email 827348260@qq.com
 * @description  O(nlogn) 快速排序法 - Quick Sort 20世纪最著名的算法之一  也可以使用插入排序处理底层
 *               快速排序最差的情况下 O(n^2)
 *
 *               用到了分治的思想
 */
public class QuickSort{

    private static void __quickSort(int[] arr, int left, int right){
        //当需要排序的数据在一定量时, 使用插入排序
        if (right - left <= 15){
            InsertionSort.insertionSort(arr, left, right);
            return;
        }
        int boundIndex = __partition(arr, left, right);
        //int boundIndex = __partition2(arr, left, right);
        __quickSort(arr, left, boundIndex - 1);
        __quickSort(arr, boundIndex + 1, right);
    }

    /**
     * 返回分界值的索引, arr[left...boundIndex - 1] < arr[boundIndex] <= arr[boundIndex + 1...right]
     * 满足条件的值放 分界值 的两边  随机化快速排序法
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int __partition(int[] arr,  int left, int right){

        //随机获取分界值, 降低最坏情况出现概率
        SortTestHelper.swap(arr, left, new Random().nextInt(right - left + 1) + left);

        int boundValue = arr[left];
        int boundIndex = left;
        for (int i = boundIndex + 1; i <= right; i++){
            if (arr[i] < boundValue){
                SortTestHelper.swap(arr, boundIndex + 1, i);
                boundIndex++;
            }
        }
        SortTestHelper.swap(arr, left, boundIndex);
        return boundIndex;
    }

    /**
     * 大量重复数据时速度较优
     * 返回分界值的索引, arr[left...boundIndex - 1] <= arr[boundIndex] <= arr[boundIndex + 1...right]
     * 满足条件的值放在数组的 两端 从两端向中间遍历 双路快速排序法
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int __partition2(int[] arr,  int left, int right){
        //随机获取分界值, 降低最坏情况出现概率
        SortTestHelper.swap(arr, left, new Random().nextInt(right - left + 1) + left);

        int boundValue = arr[left];
        int boundLeft = left + 1;
        int boundRight = right;

        while (true){
            while (boundLeft <= right && arr[boundLeft] < boundValue){ boundLeft++; }
            while (boundRight >= left + 1 && arr[boundRight] > boundValue){ boundRight--; }
            if (boundLeft > boundRight){ break; }
            else{
                SortTestHelper.swap(arr, boundLeft, boundRight);
                boundLeft++;
                boundRight--;
            }
        }
        SortTestHelper.swap(arr, left, boundRight);
        return boundRight;
    }

    /**
     * 重复数据很多事, 速度较优
     * 返回分界值的索引, 三路快速排序, 小于分界值, 等于分界值, 大于分界值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static void quickSort3Ways(int[] arr,  int left, int right){

        if (right - left <= 15){
            InsertionSort.insertionSort(arr, left, right);
            return;
        }
        //随机获取分界值, 降低最坏情况出现概率
        SortTestHelper.swap(arr, left, new Random().nextInt(right - left + 1) + left);

        int boundValue = arr[left];

        //arr[left + 1 ... lt] < boundValue
        //arr[gt ... right] > boundValue
        //arr[lt + 1 ... i) == boundValue
        int lt = left;
        int gt = right + 1;
        int index = left + 1; //正在判断的值

        while (index < gt){
            if(arr[index] < boundValue){
                SortTestHelper.swap(arr, index, lt + 1);
                index++;
                lt++;
            }else if (arr[index] > boundValue){
                SortTestHelper.swap(arr, index, gt - 1);
                gt--;
            }else {
                index++;
            }
        }
        SortTestHelper.swap(arr, left, lt);
        quickSort3Ways(arr, left, lt - 1);
        quickSort3Ways(arr, gt, right);
    }

    /**
     * 快速排序
     * @param arr
     * @param number
     */
    public static void quickSort(int[] arr, int number){
        __quickSort(arr, 0, number - 1);
    }

    public static void main(String[] args){
        int number = 100;
        int[] array = SortTestHelper.generateRandomArray(number, 0, number);
        System.out.println("排序前 : " + Arrays.toString(array));
        //quickSort(array, number);
        quickSort3Ways(array, 0, number - 1);
        System.out.println("排序后 : " + Arrays.toString(array));
    }

}
