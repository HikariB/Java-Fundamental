package com.hbLib.DesignPattern.BuliderPattern;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
