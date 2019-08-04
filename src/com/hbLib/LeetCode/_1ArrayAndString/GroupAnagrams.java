package com.hbLib.LeetCode._1ArrayAndString;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            String tmp = reOrder(strs[i]);
            if (map.containsKey(tmp)) {
                res.get(map.get(tmp)).add(strs[i]);
            } else {
                map.put(tmp, index);
                res.add(new ArrayList<>());
                res.get(index++).add(strs[i]);
            }
        }
        return res;
    }


    private String reOrder(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
