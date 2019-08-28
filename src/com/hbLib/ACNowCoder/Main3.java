package com.hbLib.ACNowCoder;

import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int dir = in.nextInt();
            int[][] matrix = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            if (dir == 1) {
                //shang
                for (int col = 0; col < 4; col++) {
                    for (int row = 0; row < 3; row++) {
                        if (matrix[row][col] == 0) {
                            continue;
                        }

                        if (matrix[row][col] == matrix[row + 1][col]) {
                            matrix[row][col] *= 2;
                            matrix[row + 1][col] = 0;
                        }
                    }
                    LinkedList<Integer> list = new LinkedList<>();
                    for (int row = 0; row < 4; row++) {
                        if (matrix[row][col] != 0) {
                            list.addLast(matrix[row][col]);
                            matrix[row][col] = 0;
                        }
                    }
                    int i = 0;
                    while (!list.isEmpty()) {
                        matrix[i][col] = list.pollFirst();
                        i++;
                    }
                }


            } else if (dir == 2) {
                //xia
                for (int col = 0; col < 4; col++) {
                    for (int row = 3; row >= 1; row--) {
                        if (matrix[row][col] == 0) {
                            continue;
                        }

                        if (matrix[row][col] == matrix[row - 1][col]) {
                            matrix[row][col] *= 2;
                            matrix[row - 1][col] = 0;
                        }
                    }
                    LinkedList<Integer> list = new LinkedList<>();
                    for (int row = 3; row >= 0; row--) {
                        if (matrix[row][col] != 0) {
                            list.addLast(matrix[row][col]);
                            matrix[row][col] = 0;
                        }
                    }
                    int i = 3;
                    while (!list.isEmpty()) {
                        matrix[i][col] = list.pollFirst();
                        i--;
                    }
                }

            } else if (dir == 3) {
                //zuo

                for (int row = 0; row < 4; row++) {
                    for (int col = 0; col < 3; col++) {
                        if (matrix[row][col] == 0) {
                            continue;
                        }

                        if (matrix[row][col] == matrix[row][col + 1]) {
                            matrix[row][col] *= 2;
                            matrix[row][col + 1] = 0;
                        }
                    }
                    LinkedList<Integer> list = new LinkedList<>();
                    for (int col = 0; col < 4; col++) {
                        if (matrix[row][col] != 0) {
                            list.addLast(matrix[row][col]);
                            matrix[row][col] = 0;
                        }
                    }
                    int i = 0;
                    while (!list.isEmpty()) {
                        matrix[row][i] = list.pollFirst();
                        i++;
                    }
                }


            } else if (dir == 4) {
                //you
                for (int row = 0; row < 4; row++) {
                    for (int col = 3; col >= 1; col--) {
                        if (matrix[row][col] == 0) {
                            continue;
                        }

                        if (matrix[row][col] == matrix[row][col - 1]) {
                            matrix[row][col] *= 2;
                            matrix[row][col - 1] = 0;
                        }
                    }
                    LinkedList<Integer> list = new LinkedList<>();
                    for (int col = 3; col >= 0; col--) {
                        if (matrix[row][col] != 0) {
                            list.addLast(matrix[row][col]);
                            matrix[row][col] = 0;
                        }
                    }
                    int i = 3;
                    while (!list.isEmpty()) {
                        matrix[row][i] = list.pollFirst();
                        i--;
                    }
                }
            }
            // dayin
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }


        }
    }
}
