package com.hbLib.ACNowCoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
//            System.out.println(in.nextInt());
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int[] help = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                help[i] = -1;
            }
            int group = 1;
            int num = 1;
            for (int i = 0; i < N; i++) {
                if (help[i] == -1) {
                    help[i] = i;
                }
                int min = help[i];
                for (int j = i + 1; j < N; j++) {
                    if (matrix[i][j] >=3) {
                        if (help[j] != -1)
                            min = Math.min(help[j],min);
                    }
                }
                help[i] =min;
                for (int j = i+1; j <N ; j++) {
                    if (matrix[i][j]>=3){
                        help[j] = min;
                    }
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(help[i]);
            }
            System.out.println(set.size());
        }
    }
}
