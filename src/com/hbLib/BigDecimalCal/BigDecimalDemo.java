package com.hbLib.BigDecimalCal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalDemo {
    //大数操作 BigInteger
    //小数操作 BigDecimal

    public static void main(String[] args) {
        /*
        // BigInteger
        //----------------------------------------------
        // 用来保存 两个大数
        BigInteger b1 = new BigInteger("987654321098765432109876543210");
        BigInteger b2 = new BigInteger("123456789012345678901234567890");

        // 两个大数的运算（加减乘除、最大值、最小值）
        System.out.println("b1 + b2 = " + b1.add(b2));        // 加
        System.out.println("b1 - b2 = " + b1.subtract(b2));   // 减
        System.out.println("b1 * b2 = " + b1.multiply(b2));   // 乘
        System.out.println("b1 / b2 = " + b1.divide(b2));     // 除
        System.out.println("max: " + b1.max(b2));        // 最大值
        System.out.println("min: " + b1.min(b2));        // 最小值
        System.out.println();

        // 除法操作，数组的第一个元素是除法的商，第二个元素是除法的余数
        BigInteger[] bArr = b1.divideAndRemainder(b2);
        System.out.println("商：" + bArr[0]);
        System.out.println("余数：" + bArr[1]);
        */


        // BigDecimal
        //----------------------------------------------
        // double 精度丢失
        System.out.println(2.00 - 1.10);

        // 用来保存 两个小数
        BigDecimal b1 = new BigDecimal("1.00");
        BigDecimal b2 = new BigDecimal("0.30");

        // 两个小数的运算（加减乘除、最大值、最小值）
        System.out.println("b1 + b2 = " + b1.add(b2));        // 加
        System.out.println("b1 - b2 = " + b1.subtract(b2));   // 减
        System.out.println("b1 * b2 = " + b1.multiply(b2));   // 乘
        // 除法，开始四舍五入模式，否则可能会报 ArithmeticException
        System.out.println("b1 / b2 = " + b1.divide(b2, BigDecimal.ROUND_HALF_UP));
        System.out.println("max: " + b1.max(b2));        // 最大值
        System.out.println("min: " + b1.min(b2));        // 最小值
        System.out.println();

        // 除法操作，数组的第一个元素是除法的商，第二个元素是除法的余数
        BigDecimal[] bArr = b1.divideAndRemainder(b2);
        System.out.println("商：" + bArr[0]);
        System.out.println("余数：" + bArr[1]);
    }
}
