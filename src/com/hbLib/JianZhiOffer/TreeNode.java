package com.hbLib.JianZhiOffer;

import java.util.Arrays;

public class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6};

        int[] b = Arrays.copyOf(a, 3);

        System.out.println("b: " + Arrays.toString(b));

        int[] c = Arrays.copyOfRange(a,1,6);
        System.out.println("c: "+ Arrays.toString(c));
        System.out.println("a: "+ Arrays.toString(a));
        Arrays.sort(a);

    }
}
