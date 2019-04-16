package com.hbLib.DesignPattern.PrototypePattern;

public class Rectangle extends Shape{
    @Override
    void draw() {
        System.out.println("this is rec");
    }

    public Rectangle() {
        type = "rec";
    }
}
