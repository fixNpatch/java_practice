package com.ssu.anton_titov.java.lesson2.task1;



abstract class Vehicle implements Transport, Comparable<Vehicle>{
    Person Driver;
    Integer VehicleCost;
    String serialNumber;
    TransportType tsType;

    Vehicle(Person person, Integer VehicleCost){
        Driver = person;
        this.VehicleCost = VehicleCost;
        generateSerialNumber();
    }

    abstract void generateSerialNumber();

    @Override
    public void stop(){
        System.out.println("Vehicle stopped");
    }

    public void move(){
        System.out.println("Vehicle is moving...");
    }

    public void engineOn(){
        System.out.println("Vehicle turns on");
    }

    public void engineOff(){
        System.out.println("Vehicle turns off");
    }
}
