package Leetcode.无重复字符的最长子串3;

import java.util.HashMap;

/**
 * @ClassName lengthOfLongestSubstring
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/26 下午9:26
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class lengthOfLongestSubstring {
    //用hashtable记住每个元素最后出现的位置
    //每当有一个重复元素出现，left就要被更新
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0 ; i < s.length() ; i++){
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            //刷新字符下标
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
