package com.chzero.algorithm.base;

import java.util.Random;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-22 11:35
 * @email 827348260@qq.com
 * @description
 */
public class SortTestHelper{

    /**
     * 生成随机数(int[])数组
     * @param count 随机数个数
     * @param rangeL 随机数下限
     * @param rangeR 随机数上线
     * @return
     */
    public static int[] generateRandomArray(int count, int rangeL, int rangeR){
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++){
            arr[i] = new Random().nextInt(rangeR - rangeL) + rangeL;
        }
        return arr;
    }

}
