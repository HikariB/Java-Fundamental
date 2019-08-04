package com.hbLib.LeetCode._2LinkedList;

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null || head.next.next == null)
            return head;
        ListNode lhead = head;
        ListNode lsecond = head.next;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode tmp = new ListNode(-1);
        int num = 0;
        while (p2 != null) {
            num++;
            if (num % 2 == 1) {
                tmp = p1;
            }
            p1.next = p2.next;

            p1 = p2;
            p2 = p2.next;

        }
        if (num % 2 == 0)
            p1.next = lsecond;
        else {
            tmp.next = lsecond;
            p1.next = null;
        }


        return lhead;

    }
}
