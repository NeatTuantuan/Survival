package Leetcode.两两交换链表中的节点24;

import 剑指offer.ListNode;

/**
 * @ClassName SwapPairs
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/27 下午7:13
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode temp = pre;
        pre.next = head;
        while (temp!=null && temp.next!=null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}
