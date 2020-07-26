package 数据结构与算法.树.深度优先遍历;

import 剑指offer.TreeNode;

import java.util.ArrayList;

/**
 * @ClassName DepthFirstSearch
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/27 下午8:41
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class DepthFirstSearch {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> DepthFirstSearch(TreeNode root){
        if (root == null){
            return result;
        }
        getPath(root);
        return result;
    }

    public void getPath(TreeNode root){
        if (root == null){
            return;
        }

        list.add(root.val);

        if (root == null && root.left == null && root.right == null){
            result.add(new ArrayList<>(list));
        }
        if (root.left!=null){
            getPath(root.left);
        }
        if (root.right!=null){
            getPath(root.right);
        }
    }
}
