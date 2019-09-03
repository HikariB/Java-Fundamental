package com.hbLib.LeetCode.DP;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int max = 1;
        int res = 0;
        int[][] dp = new int[len][len];

        //初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 2;
                if (max < dp[i][i + 1]) {
                    max = dp[i][i + 1];
                    res = i;
                }
            }
        }

        //
        for (int i = 2; i <= len - 1; i++) {
            for (int j = 0; j < len - i; j++) {
                if (dp[j + 1][j + i - 1] > 0 && s.charAt(j) == s.charAt(j+i)) {
                    dp[j][j + i] = 2 + dp[j + 1][j + i - 1];
                    if (max < dp[j][j + i]) {
                        max = dp[j][j + i];
                        res = j;
                    }
                }
            }

        }

        return s.substring(res,res+max);

    }

}
