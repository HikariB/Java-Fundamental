package com.hbLib.LeetCode._2LinkedList;

import java.beans.beancontext.BeanContext;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode aHead = headA;
        ListNode bHead = headB;
        while (headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }
        boolean isALong = false;
        if (headA == null) {
            headA = bHead;
        } else {
            headB = headA;
            headA = aHead;
            isALong = true;
        }

        while (headB != null) {
            headB = headB.next;
            headA = headA.next;
        }

        if (isALong) {
            headB = bHead;
        } else {
            headB = aHead;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;

        }
        return headA;

    }
}
