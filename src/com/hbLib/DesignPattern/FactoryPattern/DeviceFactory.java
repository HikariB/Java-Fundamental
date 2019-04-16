package com.hbLib.DesignPattern.FactoryPattern;

public class DeviceFactory extends ElectronicFactory {
    @Override
    public Device getDevice(String type, String brand) {
        if (type.equals("Keyboard"))
            return new Keyboard(brand);
        if (type.equals("Mouse"))
            return new Mouse(brand);
        return null;
    }

    @Override
    public Computer getComputer(String type, String RAM, String HDD, String CPU) {
        return null;
    }
}
