package com.hbLib.LeetCode._1ArrayAndString;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals(""))
            return 0;
        char[] chars = s.toCharArray();

        int res = 1;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < chars.length - 1; i++) {
            set.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (set.contains(chars[j])) {
//                    res = set.size() > res ? set.size() : res;
//                    set.clear();
                    break;
                } else {
                    set.add(chars[j]);
                }
            }
            res = set.size() > res ? set.size() : res;
            set.clear();
        }

        return res;
    }


    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.equals(""))
            return 0;

        int res = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int fromIndex = 0;
        int toIndex = 1;
        int size;
        for (; toIndex < s.length(); toIndex++) {
            char c = s.charAt(toIndex);
            if (map.containsKey(c)) {
                if (map.get(c) >= fromIndex) {
                    size = toIndex - fromIndex;
                    res = size > res ? size : res;
                    fromIndex = map.get(c) + 1;
                }
            }
            map.put(c, toIndex);

        }
        size = toIndex - fromIndex;
        res = size > res ? size : res;


        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        solution.lengthOfLongestSubstring2(s);
    }
}
