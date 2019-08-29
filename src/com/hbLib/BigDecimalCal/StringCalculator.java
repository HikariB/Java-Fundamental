package com.hbLib.BigDecimalCal;

import java.math.BigDecimal;

public class StringCalculator {
    public String strMultiply(String num1, String num2) {
        int Len = num1.length() + num2.length();
        int[] res = new int[Len];
        StringBuilder sb = new StringBuilder();
        // 模拟手算
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                res[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        // 进位
        for (int i = res.length - 1; i >= 1; i--) {
            if (res[i] > 9) {
                res[i - 1] += res[i] / 10;
                res[i] %= 10;
            }
        }

        // 转换为字符串
        return ArrayToString(res);
    }

    public String addStrings(String num1, String num2) {
        int len = Math.max(num1.length(), num2.length()) + 1;
        int[] res = new int[len];
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int k = res.length - 1;
        while (i >= 0 && j >= 0) {
            res[k--] = (num1.charAt(i--) - '0') + (num2.charAt(j--) - '0');
        }
        while (i >= 0) {
            res[k--] = num1.charAt(i--) - '0';
        }
        while (j >= 0) {
            res[k--] = num2.charAt(j--) - '0';
        }

        // 进位
        for (int l = res.length - 1; l > 0; l--) {
            if (res[l] > 9) {
                res[l - 1] += res[l] / 10;
                res[l] %= 10;
            }
        }

        // toString
        return ArrayToString(res);

    }

    private String ArrayToString(int[] res) {
        StringBuilder sb = new StringBuilder();
        boolean allZero = true;
        for (int i = 0; i < res.length; i++) {
            if (allZero) {
                if (res[i] == 0) {
                    continue;
                } else {
                    allZero = false;
                }
            }
            sb.append(res[i]);
        }
        if (allZero)
            return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        StringCalculator solution = new StringCalculator();
        String res = solution.addStrings("1234567812345678", "99999998765432187654321");
        System.out.println("1234567812345678+99999998765432187654321=" + res);
        res = solution.strMultiply("11111111111111","111111111111111111111111");
        System.out.println("11111111111111*11111111111111="+res);
        BigDecimal b1 = new BigDecimal("11111111111111");
        BigDecimal b2 = new BigDecimal("111111111111111111111111");
        System.out.println(b1.multiply(b2));
    }


}
