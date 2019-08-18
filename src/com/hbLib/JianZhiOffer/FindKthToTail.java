package com.hbLib.JianZhiOffer;

public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (k <= 0)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = k; i > 0; i--) {
            if (p1 == null)
                return null;
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }

}
