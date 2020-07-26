package 剑指offer.链表.删除链表中的重复节点;

import 剑指offer.ListNode;

/**
 * @ClassName deleteDuplication
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/2/29 下午8:19
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null)
            return null;

        ListNode root = new ListNode(0);
        ListNode preHead = root;
        ListNode curHead = pHead;
        root.next = pHead;

        while(curHead != null){
            if(curHead.next!=null && curHead.val == curHead.next.val){
                while(curHead.next!=null && curHead.val == curHead.next.val){
                    curHead = curHead.next;
                }
                preHead.next = curHead.next;
            }else {
                preHead = curHead;
            }
            curHead = curHead.next;
        }

        return root.next;
    }
}
