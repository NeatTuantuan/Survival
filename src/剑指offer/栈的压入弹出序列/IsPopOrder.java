package 剑指offer.栈的压入弹出序列;

import java.util.Stack;

/**
 * @ClassName IsPopOrder
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/27 下午9:46
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class IsPopOrder {
    public boolean IsPopOrder (int [] pushA,int [] popA){
        if (pushA == null || popA == null || popA.length!=pushA.length)
            return false;

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0 ; i < pushA.length ; i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
