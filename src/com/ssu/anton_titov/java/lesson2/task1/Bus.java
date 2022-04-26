package com.ssu.anton_titov.java.lesson2.task1;

public class Bus extends Vehicle implements PublicTransport {
    private Integer Passengers;
    private Integer PetrolPer100km;

    Bus(Person person, Integer VehicleCost) {
        super(person, VehicleCost);
        this.tsType = TransportType.Bus;
        this.Passengers = 0;
        this.PetrolPer100km = (int)(Math.random() * 100);
    }

    @Override
    void generateSerialNumber() {
        this.serialNumber = Integer.toString((int)(Math.random() * 10 + Math.random() * 1000));
    }


    @Override
    public void pickPassengersUp(Integer amount) {
        this.Passengers += amount;
    }

    @Override
    public void dropPassengersOff(Integer amount) {
        this.Passengers -= amount;
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.getFuelConsumption() - o.getFuelConsumption();
    }

    @Override
    public Integer getFuelConsumption() {
        return this.PetrolPer100km;
    }
}
