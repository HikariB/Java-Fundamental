package com.hbLib.DesignPattern.FactoryPattern;

public class Keyboard implements Device{
    private String brand;

    public Keyboard(String brand) {
        this.brand = brand;
    }

    @Override
    public String play() {
        return "this is keyboard";
    }
}
