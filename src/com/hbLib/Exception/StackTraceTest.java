package com.hbLib.Exception;

//checked:I/O Exception
//unchecked:error and runtime exception

import java.util.Scanner;

public class StackTraceTest {

    /*
     *compute a factorial
     * return n!=1*2*3*...*n
     */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        Throwable throwable = new Throwable();
        StackTraceElement[] frames = throwable.getStackTrace();
        for (StackTraceElement f : frames)
            System.out.println(f);
        int r;
        if (n <= 1)
            r = 1;
        else
            r = n * factorial(n - 1);
        System.out.println("return" + r);
        return r;
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter n:");
        int n = in.nextInt();
        factorial(n);
        assert 1==10;
        System.out.println("My way calculation of f(3) is "+simpleFactorial(3));

    }

    public static int simpleFactorial(int n){
        if(n==1)
            return n;
        else
            return n*simpleFactorial(n-1);
    }

}
