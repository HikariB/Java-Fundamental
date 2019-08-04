package com.hbLib.Collection;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> treemap = new TreeMap<>();
        treemap.put(3, 4);
        treemap.put(5, 8);
        treemap.put(-1, 90);
        treemap.put(66, 2);
        treemap.put(-12, 22);
        for (Map.Entry item : treemap.entrySet()) {
            System.out.println(item.getKey() + "," + item.getValue());
        }

    }
}
