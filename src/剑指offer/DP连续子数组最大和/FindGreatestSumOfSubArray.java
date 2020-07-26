package 剑指offer.DP连续子数组最大和;

/**
 * @ClassName FindGreatestSumOfSubArray
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/29 下午8:45
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int temp[] = {-10,1,2,3,4,-5,-23,3,7,-21};
    }
    public void MaxSum(int mum,int[] array){
        int sum = 0;
        int temp = array[0];

        for (int i = 1 ; i <= array.length-1 ; i++){
            if (temp+array[i] > array[i]){
                temp+=array[i];
            }else {
                temp = array[i];
            }
            if (temp > sum){
                sum = temp;
            }

        }

    }
}
