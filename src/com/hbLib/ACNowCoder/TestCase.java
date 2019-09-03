package com.hbLib.ACNowCoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TestCase {

    static class myComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }


    public static void main(String[] args) {

        Integer[] num = new Integer[]{
                1, 2, 3, 4, 5, 6, 7, 9, 8
        };
        Comparator c = new myComparator();
        Arrays.sort(num, c);
        Arrays.sort(num, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //都是奇数或偶数
                if ((o1 & 1) == (o2 & 1)) {
                    return o2 - o1;
                } else {
                    if ((o1 & 1) == 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        System.out.println(Arrays.toString(num));


        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            System.out.println(s2.contains(s1));
            System.out.println(s2.indexOf(s1));

            System.out.println(s2.replace("3", ""));
            System.out.println(s2.contains(""));
            System.out.println(s2.indexOf(""));


        }

    }


}
