package com.hbLib.DesignPattern.PrototypePattern;

public class Circle extends Shape{

    @Override
    void draw() {
        System.out.println("this is circle");
    }

    public Circle() {
        type = "circle";
    }
}
