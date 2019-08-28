package com.hbLib.MyApi;

import java.util.LinkedList;
import java.util.Queue;

public class BSTtoDoubleLinkedList {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    /**
     * 方法1：中序遍历并加入队列
     * 然后依次连接
     * 空间换时间
     */
    public static Node convert1(Node head) {
        Queue<Node> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }

        // new Head
        head = queue.poll();
        Node pre = head;
        pre.left = null;
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        cur.right = null;
        return head;

    }

    private static void inOrderToQueue(Node head, Queue<Node> queue) {
        if (head == null) {
            return;
        }

        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }

    /**
     * 递归的来做，不需要额外的空间
     */

    public static Node convert2(Node head) {
        if (head == null) {
            return head;
        }
        Node last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }

    private static Node process(Node head) {
        if (head == null)
            return null;

        Node leftE = process(head.left);
        Node rightE = process(head.right);
        Node leftS = leftE != null ? leftE.right : null;
        Node rightS = rightE != null ? rightE.right : null;
        if (leftE != null && rightE != null) {
            leftE.right = head;
            head.left = leftE;
            rightS.left = head;
            head.right = rightS;
            rightE.right = leftS;
            return rightE;
        } else if (leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        } else if (rightE != null) {
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }

    }

}
