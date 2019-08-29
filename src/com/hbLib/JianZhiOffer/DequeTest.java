package com.hbLib.JianZhiOffer;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            deque.push(i);
        }

        System.out.println(deque.peek());
        System.out.println(deque.size());
        System.out.println(deque.poll());
        System.out.println(deque.size());
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());





    }
}
