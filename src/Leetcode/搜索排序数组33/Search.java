package Leetcode.搜索排序数组33;

/**
 * @ClassName Search
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/27 下午11:03
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class Search {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] == target) return 0;
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return target;
            }
            if (nums[0] <= nums[mid]){
                //左半边有序
                if (nums[0]<=target && nums[mid] > target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                //右半边有序
                if (target > nums[mid] && target <= nums[nums.length-1]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
