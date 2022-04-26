package com.ssu.anton_titov.java.lesson3.task1;


abstract class Vehicle implements Transport, Comparable<Vehicle>{
    Person driver;
    Integer vehicleCost;
    String serialNumber;
    TransportType tsType;

    Vehicle(Person person, Integer VehicleCost){
        driver = person;
        this.vehicleCost = VehicleCost;
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
