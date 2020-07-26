package 数据结构与算法.DP.面试题0811硬币;

/**
 * @ClassName Solution
 * @Description TODO 给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * @Author tuantuan
 * @Date 2020/4/29 下午8:02
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 * 输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 **/
public class Solution {

    /**
     * 如果按照dp[i] = {dp[i-1]+dp[i-5]...+dp[i-25]}  (i>25)这样的话，比如dp[6]算出来是3。会有重复(1+1+1+1+1+1;5+1;1+5)
     * 所以需要换一中循环方式，硬币循环在外，这样能够保证小硬币总是在前
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        int []dp = new int[n+1];
        int[] coin = {1,5,10,25};
        dp[0] = 1;
        for (int i = 0 ; i < 4 ; i++){
            for (int j = coin[i] ; j < n+1 ; j++){
                if (j >= coin[i]){
                    dp[j] = (dp[j]+dp[j-coin[i]])%1000000007;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
