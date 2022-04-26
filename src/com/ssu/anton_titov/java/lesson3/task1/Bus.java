package com.ssu.anton_titov.java.lesson3.task1;

public class Bus extends Vehicle implements PublicTransport {
    private Integer passengers;
    private Integer petrolPer100km;

    Bus(Person person, Integer VehicleCost) {
        super(person, VehicleCost);
        this.tsType = TransportType.Bus;
        this.passengers = 0;
        this.petrolPer100km = (int)(Math.random() * 100);
    }

    @Override
    void generateSerialNumber() {
        this.serialNumber = Integer.toString((int)(Math.random() * 10 + Math.random() * 1000));
    }


    @Override
    public void pickPassengersUp(Integer amount) {
        this.passengers += amount;
    }

    @Override
    public void dropPassengersOff(Integer amount) {
        this.passengers -= amount;
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.getFuelConsumption() - o.getFuelConsumption();
    }

    @Override
    public Integer getFuelConsumption() {
        return this.petrolPer100km;
    }
}
