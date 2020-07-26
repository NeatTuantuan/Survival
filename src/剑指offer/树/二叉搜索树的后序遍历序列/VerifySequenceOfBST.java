package 剑指offer.树.二叉搜索树的后序遍历序列;

/**
 * @ClassName VerifySequenceOfBST
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/28 上午10:37
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class VerifySequenceOfBST {
    public boolean VerifySequenceOfBST(int [] sequence){
        if (sequence == null || sequence.length == 0)
            return false;
        return IsBST(sequence,0,sequence.length-1);
    }

    public boolean IsBST(int [] sequence, int start, int end){
        if (start >= end)
            return true;

        int root = sequence[end];
        int i ;

        for (i = start ; i < end-1 ; i++){
            if (sequence[i] > root)
                break;
        }

        for (int j = i ; j < end-1 ; j++){
            if (sequence[j] < root)
                return false;
        }
        return IsBST(sequence,start,i-1)&&IsBST(sequence,i,end-1);
    }
}
