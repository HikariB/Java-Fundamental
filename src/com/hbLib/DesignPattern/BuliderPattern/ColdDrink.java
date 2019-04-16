package com.hbLib.DesignPattern.BuliderPattern;

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }
}
