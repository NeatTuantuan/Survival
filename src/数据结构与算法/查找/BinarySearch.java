package 数据结构与算法.查找;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BinarySearch
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/3/4 下午5:19
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class BinarySearch {
    public static void main(String[] args){
//        int [] array = {49, 38, 38, 65, 97, 76, 13, 27, 50};
//        BinarySearch(array,38);
//        BinarySearch2(array,2,0,array.length-1);
        Queue<Integer> queue = new LinkedList();
        ((LinkedList<Integer>) queue).push(1);
        ((LinkedList<Integer>) queue).push(2);
        ((LinkedList<Integer>) queue).push(3);
        System.out.print(((LinkedList<Integer>) queue).getFirst());
        System.out.print(((LinkedList<Integer>) queue).getLast());
    }
    //非递归
    public static int BinarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    //递归
    public static void BinarySearch2(int[] array, int target, int low, int high){
        if (low>=high)
            return;

        int middle = (low+high)/2;
        if(array[middle] == target){
            System.out.println("find:"+middle);
        }else if (array[middle] > target){
            BinarySearch2(array,target,low,middle-1);
        }else if (array[middle] < target){
            BinarySearch2(array,target,middle+1,high);
        }else {
            System.out.println("none");
            return;
        }

    }
}
