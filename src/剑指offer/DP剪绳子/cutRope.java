package 剑指offer.DP剪绳子;

/**
 * @ClassName cutRope
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/29 下午8:36
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class cutRope {
    public int cutRope(int target){
        if (target<2)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;


        int []result = new int[target+1];

        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        for (int i = 4 ; i <= target ; i++){
            int temp = -1;
            for (int j = 0 ; j <= i/2 ; j++){
                int mid = result[j]*result[i-j];
                if (mid > temp)
                    mid = temp;
            }
            result[i] = temp;
        }
        return result[target];
    }
}
