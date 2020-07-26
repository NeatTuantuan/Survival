package 剑指offer.和为S的连续正数序列;

import java.util.ArrayList;

/**
 * @ClassName FindContinuousSequence
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/16 下午8:54
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/

//滑动窗口思想
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int start = 1 , end = 2;
        while (start < end){
            int midSum = ((start+end)*(end-start+1))>>1;
            if ( midSum == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start ; i <= end ; i++){
                    list.add(i);
                }
                result.add(list);
                start++;
            }else if (midSum < sum){
                end++;
            }else if (midSum > sum){
                start++;
            }
        }
        return result;
    }


}
