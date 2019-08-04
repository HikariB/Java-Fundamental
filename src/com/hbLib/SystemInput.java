package com.hbLib;

import java.io.*;
import java.util.Scanner;

public class SystemInput {
    //控制台输出
    public static void ScannerInputAndOut(){
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextLine());
    }
    /**
     * 字节流
     */
    public static void ByteInputAndOut(){
        //输入
        BufferedInputStream in = new BufferedInputStream(System.in);
        try {
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //输出
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        try {
            for (int i = 0; i < 5; i++) {
                out.write("hello".getBytes());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流
     */
    public static void CharInputAndOut(){
        //输入
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //输出
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for (int i = 0; i < 5; i++) {
                out.write("hello"+i);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
