package com.ssu.anton_titov.java.lesson3.task1;

public class Tram extends Vehicle implements PublicTransport {
    private Integer passengers;
    private Integer energyPerMinute;

    Tram(Person person, Integer VehicleCost) {
        super(person, VehicleCost);
        this.tsType = TransportType.Tram;
        this.passengers = 0;
        this.energyPerMinute = (int)(Math.random() * 10);
    }

    @Override
    void generateSerialNumber() {
        this.serialNumber = "NA" + (int)(Math.random() * 100) + "64R";
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
        return this.energyPerMinute;
    }
}
