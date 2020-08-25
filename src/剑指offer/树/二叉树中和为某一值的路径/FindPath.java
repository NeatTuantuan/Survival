package 剑指offer.树.二叉树中和为某一值的路径;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @ClassName FindPath
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/27 下午8:22
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class FindPath {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null || root.val > target){
            return result;
        }

        GetPath(root,target);
        //重写sort方法，按数组大小排序
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size()<o2.size()){
                    return 1;
                }else
                    return -1;
            }
        });

        return result;
    }

    //基于深度优先遍历
    public void GetPath(TreeNode root, int target){
        if (root == null || root.val > target){
            return;
        }
        list.add(root.val);
        target -= root.val;
        //当target为0且当前节点左右子树为空时，说明已经遍历到叶子结点且该路径上的值之和等于target
        if (target == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(list));
        }
        //若左右子树不为空，递归进行遍历
        if (root.left!=null){
            GetPath(root.left , target);
        }
        if (root.right != null){
            GetPath(root.right , target);
        }
        //上述条件不满足，说明当前接节点值再加就大于target了，需要移除
        list.remove(list.size()-1);
    }

}
