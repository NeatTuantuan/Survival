package 数据结构与算法.树.求树高;

import 剑指offer.TreeNode;

/**
 * @ClassName BinaryTreeHeight
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/21 下午7:26
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class BinaryTreeHeight {
    /**
     * 递归
     * @param root
     * @return
     */
    public int high(TreeNode root){
        if (root == null) return 0;
        else return 1+Math.max(high(root.left),high(root.right));
    }
}
