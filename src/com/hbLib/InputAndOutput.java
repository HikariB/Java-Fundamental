package com.hbLib;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello Java");
        // Input
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        String firstname = in.next();
        int age = in.nextInt();
        //读取密码 输入不可见
        Console cons = System.console();
        String names = cons.readLine("User name: ");
        char[] pwd = cons.readPassword("Password: ");

        //文件输入 与 输出 路径中的\ 需要多一个\ 即c:\\dir\\file.txt
        Scanner filein = new Scanner(Paths.get("myfile.txt"),"utf-8");
        PrintWriter out = new PrintWriter("myfile.txt","utf-8");



    }
}
