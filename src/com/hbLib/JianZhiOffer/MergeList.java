package com.hbLib.JianZhiOffer;

public class MergeList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode newCur = head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                head.next = cur1;
                cur1 = cur1.next;
            } else {
                head.next = cur2;
                cur2 = cur2.next;
            }
            head = head.next;
        }

        while (cur1 != null) {
            head.next = cur1;
            cur1 = cur1.next;
            head = head.next;
        }

        while (cur2 != null) {
            head.next = cur2;
            cur2 = cur2.next;
            head = head.next;
        }

        return newCur.next;

    }
}
