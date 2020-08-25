package Leetcode.三数之和15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ThreeSum
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/31 下午5:36
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        if (nums[0] > 0) return result;

        for (int i = 0 ; i < nums.length-2 ; i++){
            int start = i+1;
            int end = nums.length-2;
            //避免重复值
            if (i > 0 && nums[i] == nums[i-1]) continue;

            while(start < end){
                if (nums[start] + nums[end] == -nums[i]){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                }else if (nums[start] + nums[end] > -nums[i]){
                    end--;
                    while(start < end && nums[end] == nums[end+1]){
                        end--;
                    }
                }else if (nums[start] + nums[end] < -nums[i]){
                    start++;
                    while(start < end && nums[start] == nums[start-1]){
                        start++;
                    }
                }
            }
            return result;

        }


        return null;
    }
}
