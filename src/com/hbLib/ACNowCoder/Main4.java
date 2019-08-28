package com.hbLib.ACNowCoder;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int[] candy = new int[N];
            for (int i = 0; i < N; i++) {
                candy[i] = in.nextInt();
            }
            int[] help = new int[N];
            for (int i = 0; i < N; i++) {
                help[i] = -1;
            }


            for (int i = 0; i < N; i++) {
                if (help[i] == -1)
                    help[i] = i;
                int min = help[i];
                for (int j = i + 1; j < N; j++) {
                    if (isOk(candy[i], candy[j]))
                        if (help[j] != -1) {
                            min = Math.min(min, help[j]);
                        }
                }
                help[i] = min;
                for (int j = i + 1; j < N; j++) {
                    if (isOk(candy[i], candy[j]))
                        help[j] = min;
                }
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                if (map.containsKey(help[i])) {
                    int count = map.get(help[i]);
                    map.put(help[i], count + 1);
                } else {
                    map.put(help[i], 1);
                }
            }
            int max = -1;
            for (Integer i : map.values()) {
                max = Math.max(max, i);
            }
            System.out.println(max);


        }
    }


    private static boolean isOk(int a, int b) {
        int min = Math.min(a, b);
        for (int i = 2; i <= min; i++) {
            if (a % i == 0 && b % i == 0)
                return true;
        }
        return false;
    }
}
