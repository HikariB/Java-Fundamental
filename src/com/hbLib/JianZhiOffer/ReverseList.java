package com.hbLib.JianZhiOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        if (head == null)
            return head;
        while (head != null){
            deque.push(head);
            head = head.next;
        }
        ListNode newHead = deque.pop();
        ListNode tempHead = newHead;
        while (deque.size() > 0){
            tempHead.next = deque.pop();
            tempHead = tempHead.next;
        }
        tempHead.next = null;
        return newHead;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode tempNode = new ListNode(0);
        ListNode ite = head;
        ListNode nextNode;
        while (ite != null){
            nextNode = ite.next;
            ite.next = tempNode.next;
            tempNode.next = ite;
            ite = nextNode;

        }
        return tempNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ReverseList solution = new ReverseList();
        ListNode ltemp = l1;
        while (ltemp != null){
            System.out.print(ltemp.val + " ");
            ltemp = ltemp.next;
        }
        ListNode lres= solution.reverseList2(l1);
        ltemp = lres;
        System.out.println();
        while (ltemp != null){
            System.out.print(ltemp.val + " ");
            ltemp = ltemp.next;
        }

    }



}

