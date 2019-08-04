package com.hbLib.LeetCode._2LinkedList;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null)
            return l2;
        if (l1 != null && l2 == null)
            return l1;
        if (l1 == null && l2 == null)
            return null;
        int flag = 0;
        int tmp;
        ListNode lres = new ListNode(0);
        ListNode lhead = lres;
        while (l1 != null || l2 != null || flag != 0) {
            tmp = 0;
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            tmp += flag;
            if (tmp > 9) {
                tmp -= 10;
                flag = 1;
            } else
                flag = 0;
            ListNode ltmp = new ListNode(tmp);
            lres.next = ltmp;
            lres = ltmp;
        }
        return lhead.next;
    }


}
