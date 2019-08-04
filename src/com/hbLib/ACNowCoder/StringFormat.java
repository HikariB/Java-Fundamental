package com.hbLib.ACNowCoder;

import java.math.BigDecimal;
import java.util.Scanner;

public class StringFormat {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


        String str=null;
        str=String.format("Hi,%s", "王力");
        System.out.println(str);
        str=String.format("Hi,%s:%s.%s", "王南","王力","王张");
        System.out.println(str);
        System.out.printf("字母a的大写是：%c %n", 'A');
        System.out.printf("3>7的结果是：%b %n", 3>7);
        System.out.printf("100的一半是：%d %n", 100/2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50*0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');


        str=String.format("格式参数$的使用：%1$d,%2$s", 99,"abc");
        System.out.println(str);
        //+使用
        System.out.printf("显示正负数的符号：%+d与%d%n", 99,-99);
        //补O使用
        System.out.printf("最牛的编号是：%03d%n", 7);
        //空格使用
        System.out.printf("Tab键的效果是：% 8d%n", 7);
        //.使用
        System.out.printf("整数分组的效果是：%,d%n", 9989997);
        //.使用
        System.out.printf("小数分组的效果是：%,f%n", 9989997.1928912);
        //空格和小数点后面个数
        System.out.printf("一本书的价格是：% 50.5f元%n", 49.8);


        // 四舍五入
        while (in.hasNext()) {
            String cmd = in.next();
            while (cmd.equals("4s5r")) {
                double d = in.nextDouble();
                System.out.println(String.format("%.6f", d));  //%.6f 自带四舍五入的属性

                double d1 = new BigDecimal(d).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
                System.out.println(d1);

            }
        }

    }
}
