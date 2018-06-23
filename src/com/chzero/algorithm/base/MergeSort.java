package com.chzero.algorithm.base;

import java.util.Arrays;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-23 18:17
 * @email 827348260@qq.com
 * @description 归并排序 o(nlogn) (自顶向下 和 自底向上) 当划分的到一定数量时, 可使用其他排序方式进行排序
 */
public class MergeSort{

    private static void __mergeSort(int[] arr, int left, int right){
        //当左右值相等时, 每一个归并只有一个值
        if (right - left <= 15){
            InsertionSort.insertionSort(arr, left, right);
            return;
        }
        //获取归并中点
        int middle = (left + right) / 2;
        //对中点左右值进行归并
        __mergeSort(arr, left, middle);
        __mergeSort(arr, middle + 1, right);
        if (arr[middle] > arr[middle + 1]){
            __merge(arr, left, middle, right);
        }
    }

    /**
     * 将arr[left...middle]和arr[middle + 1...right]两部分进行合并;
     * @param arr 数组
     * @param left 起点索引
     * @param middle 中点索引
     * @param right 末端索引
     */
    private static void __merge(int[] arr, int left, int middle, int right){
        //临时空间, 用于合并数据
        int[] temp = new int[right - left + 1];
        for (int i = left; i <= right; i++){ temp[i - left] = arr[i]; }

        int leftValue = left;
        int rightValue = middle + 1;
        for (int k = left; k <= right; k++){
            if (leftValue > middle){
                arr[k] = temp[rightValue - left];
                rightValue++;
            }else if (rightValue > right){
                arr[k] = temp[leftValue - left];
                leftValue++;
            }else if (temp[leftValue - left] < temp[rightValue - left]){
                arr[k] = temp[leftValue - left];
                leftValue++;
            }else{
                arr[k] = temp[rightValue - left];
                rightValue++;
            }
        }
    }

    /**
     * 归并排序(自顶向下)
     * @param arr 需要排序的数据
     * @param number 数据量
     */
    public static void mergeSort(int[] arr, int number){
        __mergeSort(arr, 0, number - 1);
    }

    /**
     * 归并排序(自底向上)
     * @param arr 需要排序的数据
     * @param number 数据量
     */
    public static void mergeSortBU(int[] arr, int number){
        for (int size = 1; size <= number ; size += size){
            for(int i =0;i+size< number; i+=size+size){
                __merge(arr, i, i + size - 1, ((i + size + size - 1) <= (number - 1)) ? (i + size + size - 1) : (number - 1));
            }
        }
    }

    public static void main(String[] args){
        int number = 20;
        int[] array = SortTestHelper.generateRandomArray(number, 0, number);
        System.out.println("排序前 : " + Arrays.toString(array));
        //mergeSort(array, number);
        mergeSortBU(array, number);
        System.out.println("排序后 : " + Arrays.toString(array));
    }

}
