package 数据结构与算法.树.中序遍历;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName InorderTraversal
 * @Description TODO 二叉树中序遍历
 * @Author tuantuan
 * @Date 2020/2/27 下午9:01
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class InorderTraversal {
    private ArrayList<Integer> list = new ArrayList();

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        if(root.left!=null){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right);
        }
        return list;
    }

    public void inorderTraversal2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top);
            root = top.right;
        }
    }


}
