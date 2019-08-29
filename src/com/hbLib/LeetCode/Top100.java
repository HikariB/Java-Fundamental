package com.hbLib.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Top100 {
    public int maxArea_11(int[] height) {
        if (height.length <= 1)
            return 0;
        int i = 0;
        int j = height.length - 1;
        int max = -1;
        while (i < j) {
            int newArea = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, newArea);
            if (height[i] <= height[j])
                i++;
            else
                j--;
        }


        return max;

    }

    public boolean isValid_20(String s) {
        if (s == null || (s.length() & 1) == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (sc == '(' || sc == '[' || sc == '{') {
                stack.push(sc);
            } else if (sc == ')' || sc == ']' || sc == '}') {
                if (stack.isEmpty())
                    return false;
                char c = stack.pop();

                if (sc == ')' && c != '(') {
                    return false;
                }
                if (sc == ']' && c != '[') {
                    return false;
                }
                if (sc == '}' && c != '{') {
                    return false;
                }

            } else
                return false;
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public List<String> generateParenthesis_22(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
            return ans;
        }
        for (int i = 1; i <= n; i++) {
            for (String leftStr : generateParenthesis_22(i - 1))
                for (String rightStr : generateParenthesis_22(n - i))
                    ans.add("(" + leftStr + ")" + rightStr);
        }
        return ans;
    }

    public int longestValidParentheses(String s) {
        int max = -1;
        int right = 0;
        int pos = 0; // (
        int neg = 0; // )
        while (right < s.length()) {
            if (s.charAt(right) == '(') {
                pos++;
            } else if (s.charAt(right) == ')') {
                neg++;
            }
            if (neg > pos) {
                pos = 0;
                neg = 0;
            } else {
                max = Math.max(max, Math.min(neg,pos));
            }
            right++;
        }
        return max;
    }
}
