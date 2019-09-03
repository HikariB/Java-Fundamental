package com.hbLib.ACNowCoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BackTrackExample {

    static List<List<String>> res;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int s = Integer.parseInt(in.nextLine());
            for (int i = 0; i < s; i++) {
                String p1 = in.nextLine();
                String p2 = in.nextLine();

                System.out.println("{");

                res = new LinkedList<>();
                LinkedList<String> pre = new LinkedList<>();
                String preStr = "";
                tryProcess(p1, p2, 0, pre, preStr);
                if (res.size() > 0) {
                    for (List<String> list : res) {
                        System.out.println(String.join(" ", list));
                    }
                }

                System.out.println("}");
            }
        }
    }

    private static void tryProcess(String p1, String p2, int i, LinkedList<String> pre, String preStr) {
        if (!p2.contains(preStr))
            return;
        if (i == p1.length()) {
            if (preStr.equals(p2)) {
                List<String> preNew = new LinkedList<>(pre);
                res.add(preNew);
            }
            return;
        }

        if (!p2.contains(String.valueOf(p1.charAt(i)))) {
            pre.addLast("d");
            tryProcess(p1, p2, i + 1, pre, preStr);
            pre.removeLast();
            return;
        }

        pre.addLast("d");
        tryProcess(p1, p2, i + 1, pre, preStr);
        pre.removeLast();

        pre.addLast("l");
        preStr = p1.charAt(i) + preStr;
        tryProcess(p1, p2, i + 1, pre, preStr);
        pre.removeLast();
        preStr = preStr.substring(1);


        pre.addLast("r");
        preStr = preStr + p1.charAt(i);
        tryProcess(p1, p2, i + 1, pre, preStr);
        preStr = preStr.substring(0, preStr.length() - 1);
        pre.removeLast();

        return;
    }
}