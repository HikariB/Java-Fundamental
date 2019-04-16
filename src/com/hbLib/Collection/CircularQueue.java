package com.hbLib.Collection;

public class CircularQueue {

    public static void main(String[] args) {
        // write your code here
        System.out.println("hello idea");

        MycircularQueue q1 = new MycircularQueue(3);
        q1.enQueue(1);
        q1.enQueue(2);
        q1.enQueue(3);
        System.out.println(q1.enQueue(4));
        System.out.println("the rear is " + q1.Rear());
        System.out.println(q1.isFull());
        q1.deQueue();
        q1.enQueue(4);
        System.out.println("after the rear is " + q1.Rear());


    }
}

class MycircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int length;

    public MycircularQueue(int length) {
        data = new int[length];
        head = -1;
        tail = -1;
        this.length = length;
    }

    public boolean enQueue(int i) {
        if (isFull())
            return false;
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % length;
        data[tail] = i;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % length;
        return true;
    }

    public boolean isFull() {
        return (tail + 1) % length == head;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public int Rear() {
        if (!isEmpty()) {
            return data[tail];
        }
        return -1;
    }
}