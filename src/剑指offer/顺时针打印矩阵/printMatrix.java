package 剑指offer.顺时针打印矩阵;

import java.util.ArrayList;

/**
 * @ClassName printMatrix
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/16 下午7:29
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/

//   lc    rc
//lr 1,2, 3, 4
//   5,6, 7, 8
//   9,10,11,12
//rr 13,14,15,16

public class printMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int lc = 0;
        int lr = 0;
        int rc = matrix.length-1;
        int rr = matrix[0].length-1;
        //处理当前左上角和右下角形成一圈情况 处理完后 左上角向下 右下角向上 继续处理下一圈
        while(lr<=rr && lc<=rc){
            whirl(matrix, lc++, lr++, rc--, rr--, list);
        }
        return list;
    }
    private void whirl(int[][] matrix, int lc, int lr, int rc, int rr, ArrayList<Integer> list){
        //只有一行
        if (lr == rr){
            for (int i = lc ; i <= rc ; i++){
                list.add(matrix[lr][i]);
            }
            return;
        }
        //只有一列
        if (lc == rc){
            for (int i = lr ; i <= rr ; i++){
                list.add(matrix[i][lc]);
            }
            return;
        }
        //一圈
        //打印第一行
        for (int i = lc ; i <= rc ; i++){
            list.add(matrix[lr][i]);
        }
        //打印最后一列
        for (int i = lr+1 ; i <= rr ; i++){
            list.add(matrix[i][rc]);
        }
        //打印最后一行
        for (int i = rc-1 ; i >= lc ; i--){
            list.add(matrix[rr][i]);
        }
        //打印第一列
        for (int i = rr-1 ; i >= lr+1 ; i--){
            list.add(matrix[i][lc]);
        }

    }
}
