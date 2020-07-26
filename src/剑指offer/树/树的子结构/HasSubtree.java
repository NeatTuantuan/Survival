package 剑指offer.树.树的子结构;

import 剑指offer.TreeNode;

/**
 * @ClassName HasSubtree
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/27 下午9:39
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2){
        if (root1 == null || root2 == null)
            return false;

        return IsSubtree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public boolean IsSubtree(TreeNode root1,TreeNode root2){
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;

        if (root1.val == root2.val)
            return IsSubtree(root1.left,root2.left)&&IsSubtree(root1.right,root2.right);

        return false;
    }
}
