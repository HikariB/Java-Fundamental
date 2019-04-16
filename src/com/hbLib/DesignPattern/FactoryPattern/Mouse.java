package com.hbLib.DesignPattern.FactoryPattern;

public class Mouse implements Device{
    private String brand;

    public Mouse(String brand) {
        this.brand = brand;
    }

    @Override
    public String play() {
        return "this is mouse";
    }
}
