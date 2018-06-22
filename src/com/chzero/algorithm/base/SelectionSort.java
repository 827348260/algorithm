package com.chzero.algorithm.base;

import java.util.Arrays;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-22 11:33
 * @email 827348260@qq.com
 * @description
 */
public class SelectionSort{

    public static void main(String[] args){
        int number = 10;
        int[] array = SortTestHelper.generateRandomArray(number, 0, number);

        System.out.println(Arrays.toString(array));
    }

}
