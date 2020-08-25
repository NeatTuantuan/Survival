package Leetcode.二叉树最大路径和124;

import 剑指offer.TreeNode;

/**
 * @ClassName MaxPathSum
 * @Description TODO 相思题目687.最长同值路径/543
 * @Author tuantuan
 * @Date 2020/8/24 下午7:14
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class MaxPathSum {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        fun(root);
        return result;
    }

    public int fun(TreeNode root){
        if (root == null) return 0;

        int leftVal = Math.max(fun(root.left),0);
        int rightVal = Math.max(fun(root.right),0);

        int total = root.val+leftVal+rightVal;

        result = Math.max(total,result);

        return root.val+Math.max(leftVal,rightVal);
    }
}
