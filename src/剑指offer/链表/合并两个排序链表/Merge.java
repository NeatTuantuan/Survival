package 剑指offer.链表.合并两个排序链表;

import 剑指offer.ListNode;

/**
 * @ClassName Merge
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/27 下午9:29
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class Merge {
    public ListNode Merge(ListNode list1, ListNode list2){
        if (list1 == null && list2 == null){
            return null;
        }

        if (list1 == null){
            return list2;
        }

        if (list2 == null){
            return list1;
        }

        if (list1.val < list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }else {
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }
}
