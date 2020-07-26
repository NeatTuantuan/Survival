package 剑指offer.字符串的排列;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;

/**
 * @ClassName Permutation
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/28 上午10:46
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class Permutation {
    public ArrayList<String> Permutation(String str){
        ArrayList<String> list = new ArrayList<>();
        if (str == null)
            return list;
        fun(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;
    }

    public void fun(char[] array, int start, ArrayList list){
        if (start == array.length-1){
            list.add(String.valueOf(array));
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = start ; i < array.length ; i++){
            if (!set.contains(array[i])){
                set.add(array[i]);
                swap(array,start,i);
                fun(array,start+1,list);
                swap(array,start,i);
            }
        }
    }

    public void swap(char[] arr, int i , int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
