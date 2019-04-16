package com.hbLib.Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
* 统计文件中单词不重复的数量
* 运用HashSet
*/
public class SetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }

        }

        Iterator<String> wordIter = words.iterator();
        for (int i = 0; i <= 20 && wordIter.hasNext(); ++i) {
            System.out.println(wordIter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime + " Milliseconds");
    }
}
