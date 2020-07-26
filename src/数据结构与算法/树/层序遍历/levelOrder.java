package 数据结构与算法.树.层序遍历;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName levelOrder
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/15 下午3:48
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class levelOrder {
    /**
     * 多叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0 ; i < size ; i++){
                Node temp = queue.poll();
                level.add(temp.val);
                queue.addAll(temp.children);
            }
            list.add(level);
        }
        return list;
    }

    /**
     * 二叉树
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0 ; i < size ; i++){
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left!=null) queue.add(temp.left);
                if (temp.right!=null) queue.add(temp.right);
            }
            result.add(level);

        }
        return result;

    }

    /**
     *  多叉树
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
