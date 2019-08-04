package com.hbLib.Stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class IOTest {

    public static void main(String[] args) throws IOException {
        final int THRESHOLD = 1;
        String contents = new String(Files.readAllBytes(Paths.get("./data.txt")), UTF_8);
        System.out.println(contents);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count = 0;
        for (String w : words)
            if (w.length() > THRESHOLD)
                count++;
        System.out.println("Iteration: " + count);

        count = words.stream().filter(w -> w.length() > THRESHOLD).count();
        System.out.println("Stream: " + count);

        count = words.parallelStream().filter(w -> w.length() > THRESHOLD).count();
        System.out.println("Parallel Stream: " + count);

    }
}
