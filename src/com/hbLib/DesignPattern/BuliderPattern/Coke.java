package com.hbLib.DesignPattern.BuliderPattern;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 10.0f;
    }
}
