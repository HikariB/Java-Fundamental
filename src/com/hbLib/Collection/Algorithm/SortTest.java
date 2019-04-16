package com.hbLib.Collection.Algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 50; ++i) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> subary = numbers.subList(0,6);
        System.out.println(subary);
        Collections.sort(subary);
        System.out.println(subary);
    }
}
