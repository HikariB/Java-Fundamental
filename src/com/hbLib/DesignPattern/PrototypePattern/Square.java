package com.hbLib.DesignPattern.PrototypePattern;

public class Square extends Shape {
    @Override
    void draw() {
        System.out.println("this is square");
    }

    public Square() {
        type = "square";
    }
}
