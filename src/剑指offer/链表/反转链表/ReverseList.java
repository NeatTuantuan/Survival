package 剑指offer.链表.反转链表;

import 剑指offer.ListNode;

/**
 * @ClassName ReverseList
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/29 下午9:01
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class ReverseList {
    public ListNode ReverseList(ListNode head){
        if (head == null)
            return null;

        ListNode first = null;
        ListNode second = head;
        ListNode third = head.next;

        while(second != null){
            second.next = first;
            first = second;
            second = third;
            if (third.next!=null){
                third = third.next;
            }

        }
        return second;
    }
}
