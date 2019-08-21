package com.hbLib.JianZhiOffer;


public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode preHead = new ListNode(-1);
        preHead.next = pHead;
        ListNode pre = preHead;
        ListNode curr = pHead;
        boolean isMove = false;
        while (curr != null){
            isMove = false;
            while (curr.next != null &&curr.val == curr.next.val){
                curr = curr.next;
                isMove = true;
            }
            if (isMove){
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return preHead.next;
    }
}

