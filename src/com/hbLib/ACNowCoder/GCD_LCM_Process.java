package com.hbLib.ACNowCoder;

/**
 * 最大公约数GCD
 * 最小公倍数LCM
 */
public class GCD_LCM_Process {

    public static int getGCD(int a, int b) {
        return b != 0 ? getGCD(b, a % b) : a;
    }

    public static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    public static void main(String[] args) {
        System.out.println("27,12 的最大公约数是：" + getGCD(12, 27));
        System.out.println("27,12 的最小公倍数是：" + getLCM(27, 12));
        System.out.println(12 % 27);
    }

}
