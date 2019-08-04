package com.hbLib.LeetCode._1ArrayAndString;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int start = 0;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (i <= 2) {
                    dp[j][j + i - 1] = s.charAt(j) == s.charAt(j + i - 1);
                    if (i == 2 && maxLen < 2 && dp[j][j + 1]) {
                        maxLen = 2;
                        start = j;
                    }
                } else {
                    dp[j][j + i - 1] = s.charAt(j) == s.charAt(j + i - 1) && dp[j + 1][j + i - 2];
                    if (dp[j][j + i - 1] && maxLen < i) {
                        maxLen = i;
                        start = j;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);

    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        String s = "babad";
//        solution.longestPalindrome(s);

        String s1  = s;
        s.concat("2");
        System.out.println(s1);



    }
}
