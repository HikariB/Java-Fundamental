package com.hbLib.MyApi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecursiveExample {

    /**
     * 汉诺塔 递归算法
     * 有柱子 x y z，x柱子上有原始的N个盘子，根据以下规则将X上的盘子移动到y柱子上
     * 1) 每次移动只能移动一个盘子
     * 2）始终保持小的盘子位于大的盘子之上
     * 输出 需要移动的步数，并打印出每一步的步骤
     */

    public static int Hanoi(int pNum) {
        System.out.println("Init Status: x-" + pNum + ",y-0,z-0");
        return hanoiCoreProcess(pNum, "x", "y", "z");
    }

    private static int hanoiCoreProcess(int pNum, String from, String to, String help) {
        if (pNum <= 1) {
            System.out.println("move:" + from + " -> " + to);
            return 1;
        }

        int step = hanoiCoreProcess(pNum - 1, from, help, to);
        System.out.println("move:" + from + " -> " + to);
        step++;
        step += hanoiCoreProcess(pNum - 1, help, to, from);
        return step;
    }

    /**
     * 字符串的全排列
     *
     * @param pStr
     * @return
     */


    public static List<String> Permutation(String pStr) {
        System.out.println("Permutation Start, Original String: " + pStr);
        if (pStr == null) {
            return null;
        }

        List<String> res = new ArrayList<>();

        if (pStr.length() <= 1) {
            res.add(pStr);
            System.out.println("Permutation Result: "+res);
            return res;
        }

        permutationCoreProcess(pStr, 0, pStr.length() - 1, res);
        System.out.println("Permutation Result: "+res);
        return res;
    }

    private static void permutationCoreProcess(String pStr, int from, int to, List<String> res) {
        if (from == to) {
            res.add(pStr);
        }
        for (int i = from; i <= to; i++) {
            String str = swap(pStr, from, i);
            permutationCoreProcess(str, from + 1, to, res);
        }

    }

    private static String swap(String pStr, int i, int j) {
        StringBuilder sb = new StringBuilder(pStr);
        char c = pStr.charAt(i);
        sb.setCharAt(i, pStr.charAt(j));
        sb.setCharAt(j, c);
        return sb.toString();
    }


    public static void main(String[] args) {
//        System.out.println("STEPS: " + Hanoi(3));
        Permutation("acc");
    }


}
