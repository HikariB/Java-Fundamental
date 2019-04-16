package com.hbLib.DesignPattern.FactoryPattern;

import javax.print.DocFlavor;

public class ComputerFactory extends ElectronicFactory{
    public  Computer getComputer(String type, String RAM, String HDD, String CPU) {
        if (type.equals("PC"))
            return new PC(RAM, HDD, CPU);
        if (type.equals("Server"))
            return new Server(RAM, HDD, CPU);
        return null;
    }

    @Override
    public Device getDevice(String type,String brand) {
        return null;
    }

    public static void main(String[] args) {
        ComputerFactory computerFactory = new ComputerFactory();
        Computer pc = computerFactory.getComputer("PC","2 GB","500 GB","2.4GHz");
        Computer server = computerFactory.getComputer("Server","16 GB","1 TB","2.9GHz");
        System.out.println("PC Info: " + pc);
        System.out.println("Server Info: " + server);
    }
}
