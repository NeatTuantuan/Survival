package 数据结构与算法.排序;

import java.util.HashMap;
/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/25 上午11:46
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class QuickSort {
    public static void main(String[] args){
        int[] arr={6,3,8,2,9,1};
        QuickSort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.println(i+",");
        }

    }

    public static void QuickSort(int[] array ,int start, int end){
        if (start >= end)
            return;

        //基准元素，默认以第一个元素为基准
        int key = array[start];
        int i = start;
        int j = end;

        while(i < j){
            while(array[j] >= key && i<j){
                j--;
            }

            while (array[i]<=key && i<j){
                i++;
            }

            //j,i元素互换
            if (i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[start] = array[i];
        array[i] = key;

        QuickSort(array,start,i-1);
        QuickSort(array,i+1,end);
    }
}
