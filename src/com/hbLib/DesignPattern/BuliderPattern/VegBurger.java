package com.hbLib.DesignPattern.BuliderPattern;

public class VegBurger extends Burger {

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 15.0f;
    }
}
