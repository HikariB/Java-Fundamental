package com.hbLib.DesignPattern.FactoryPattern;

public class FactoryProducer {
    public static ElectronicFactory getFactory(String choice) {
        if (choice.equals("Computer"))
            return new ComputerFactory();
        if (choice.equals("Device"))
            return new DeviceFactory();
        return null;
    }

    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();
        ElectronicFactory computerFactory = factoryProducer.getFactory("Computer");
        Computer computer = computerFactory.getComputer("Server", "5 GB", "2 TB", "2.9GHz");
        System.out.println("this is computer" + computer);
        ElectronicFactory deviceFactory = factoryProducer.getFactory("Device");
        Device device = deviceFactory.getDevice("Mouse", "Razer");
        System.out.println(device.play());
    }


}


