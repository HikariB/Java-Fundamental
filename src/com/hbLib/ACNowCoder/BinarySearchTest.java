package com.hbLib.ACNowCoder;

import java.util.Arrays;
import java.util.Scanner;


/**
 * binary Search 只能搜索同类型的元素
 */
public class BinarySearchTest {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


        int[] a = {1, 2, 3, 4};
        while (in.hasNext()){
            int key  = Arrays.binarySearch(a, (int) in.nextDouble());
            System.out.println(key);
        }

    }
}
