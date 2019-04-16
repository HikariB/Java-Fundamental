package com.hbLib.DesignPattern.FactoryPattern;

public abstract class ElectronicFactory {
    public abstract Device getDevice(String type, String brand);

    public abstract Computer getComputer(String type, String RAM, String HDD, String CPU);
}
