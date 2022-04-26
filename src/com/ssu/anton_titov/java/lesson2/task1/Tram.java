package com.ssu.anton_titov.java.lesson2.task1;

public class Tram extends Vehicle implements PublicTransport{
    private Integer Passengers;
    private Integer EnergyPerMinute;

    Tram(Person person, Integer VehicleCost) {
        super(person, VehicleCost);
        this.tsType = TransportType.Tram;
        this.Passengers = 0;
        this.EnergyPerMinute = (int)(Math.random() * 10);
    }

    @Override
    void generateSerialNumber() {
        this.serialNumber = "NA" + (int)(Math.random() * 100) + "64R";
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
        return this.EnergyPerMinute;
    }
}
