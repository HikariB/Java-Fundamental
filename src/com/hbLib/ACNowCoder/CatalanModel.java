package com.hbLib.ACNowCoder;

public class CatalanModel {

    // select m items from n
    // C(n,m)=n!/m!/m!
    public static long select(int n, int m) {
        if ((m == 0) || (n == 0)) {
            return 1;
        }
        long res;
        long numerator = 1;
        long denominator = 1;
        m = Math.min(m, n - m);
        for (int i = 1; i <= m; i++) {
            denominator *= i;
        }
        for (int i = 0; i < m; i++) {
            numerator *= n - i;
        }
        res = numerator / denominator;
        return res;
    }

    // n >= 2 n < 36 否则溢出
    // 1 2 5 14 42 132 429
    public static long catalanCal(int n) {
        long[] dp = new long[n];

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n - 1];


    }


    public static void main(String[] args) {
//        System.out.println(select(6, 3));
        System.out.println(catalanCal(36));
        System.out.println(Long.MAX_VALUE);

    }


}
