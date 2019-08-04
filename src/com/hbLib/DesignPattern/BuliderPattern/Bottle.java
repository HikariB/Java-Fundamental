package com.hbLib.DesignPattern.BuliderPattern;

import java.io.Serializable;

public class Bottle implements Packing,Serializable {
    @Override
    public String pack() {
        return "Bottle";
    }



}
