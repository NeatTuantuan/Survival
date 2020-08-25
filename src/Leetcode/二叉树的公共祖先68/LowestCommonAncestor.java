package Leetcode.二叉树的公共祖先68;

import 剑指offer.TreeNode;

/**
 * @ClassName LowestCommonAncestor
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/8/24 下午9:20
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
