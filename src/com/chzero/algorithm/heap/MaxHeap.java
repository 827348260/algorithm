package com.chzero.algorithm.heap;

import com.chzero.algorithm.base.SortTestHelper;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-24 15:25
 * @email 827348260@qq.com
 * @description 堆 结构   二叉堆是一种完全二叉树; 堆中某节点的值总是不大于其父节点的值; 堆总是一颗完全二叉树(最大堆);
 */
public class MaxHeap{

    private int[] data;
    private int count;

    public MaxHeap(int capacity){
        this.data = new int[capacity + 1];
        this.count = 0;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void insert(int numer){
        this.data[this.count + 1] = numer;
        this.count++;


    }

    private void shiftUp(int index){
        while (index > 1 && this.data[index / 2] < this.data[index]){
            SortTestHelper.swap(this.data, index/2, index);
            index /= 2;
        }
    }

}
