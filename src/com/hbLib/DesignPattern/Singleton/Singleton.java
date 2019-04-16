package com.hbLib.DesignPattern.Singleton;

public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    //The only way to get a instance of this class!
    public static Singleton getInstance() {
        return instance;
    }

    public void play(){
        System.out.println("hello, this is a singleton");
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.play();

    }
}
