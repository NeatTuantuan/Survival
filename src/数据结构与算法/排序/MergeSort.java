package 数据结构与算法.排序;

import java.util.Stack;

/**
 * @ClassName MergeSort
 * @Description TODO 归并排序
 * @Author tuantuan
 * @Date 2020/4/12 下午4:26
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class MergeSort {
    public static void main(String[] args) {
        Stack stack = new Stack();
        int a[] = {49, 38, 65, 97, 76, 13, 27, 50};
        mergeSort(a,0,a.length-1);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }

    public static void mergeSort(int arr[], int start, int end){
        if (start < end){
            int mid = (start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }

    public static void merge(int arr[], int left, int mid, int right){
        //辅助数组
        int temp[] = new int[arr.length];
        //检测指针
        int p1 = left;
        int p2 = mid+1;
        //存放指针
        int k = left;

        while (p1<=mid && p2<=right){
            if (arr[p1] <= arr[p2]){
                temp[k++] = arr[p1++];
            }else {
                temp[k++] = arr[p2++];
            }
        }
        //若上一个序列未检测完直接讲后面的所有元素加到合并的序列中
        while(p1<=mid) temp[k++] = arr[p1++];
        while(p2<=right) temp[k++] = arr[p2++];

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

}
