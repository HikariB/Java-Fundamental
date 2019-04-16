package com.hbLib;

public class StringTest {
    public static void main(String[] args) {
        String string = "hello";
        System.out.println(string.substring(0, 3));
        string += "Java";
        System.out.println(string);
        String all = String.join("/","s","m","l","xl");
        System.out.println(all);
        //字符串属于不可变量，只能给变量引用到一个新的字符串，即创建一个新的字符串，然后修改引用

        System.out.println("HELlo".equalsIgnoreCase("hello"));

        //StringBuilder 类是为了避免每次连接都产生新的字符串而浪费空间
        StringBuilder builder = new StringBuilder();
        builder.append('a');
        builder.append("hello");
        String completedString = builder.toString();
        //另一个是StringBuffer 其效率不高但是适用于多线程修改字符串


    }
}
