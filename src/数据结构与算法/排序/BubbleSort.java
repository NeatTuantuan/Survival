package 数据结构与算法.排序;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/25 上午11:38
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class BubbleSort {
    public static void main(String[] args){
        int[] arr={6,3,8,2,9,1};
        BubbleSort(arr);
        for(int i : arr){
            System.out.println(i+",");
        }


    }

    public static void BubbleSort(int[] arr){
        //外层循环控制排序趟数
        for(int i=0;i<arr.length-1;i++){
            //内层循环控制每一趟排序多少次
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
