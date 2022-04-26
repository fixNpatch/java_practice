package com.ssu.anton_titov.java.lesson2.task1;

import java.util.Arrays;

enum CompanyType{
    Municipal,
    Private
}

enum TransportType{
    Tram, Bus
}

class Company {
    private String name;
    private CompanyType type;
    private Vehicle[] Park;
    private Integer parkSize;
    private TransportType tsType;


    Company(String companyName, CompanyType type, TransportType tsType , Integer parkSize){
        this.type = type;
        this.name = companyName;
        this.parkSize = parkSize;

        switch (type){
            case Private:
                break;
            case Municipal:
                break;
        }

        this.tsType = tsType;
        this.Park = new Vehicle[this.parkSize];
        createPark();
    }



    private void createPark(){
        for(int i = 0; i < this.parkSize; i++){

            Person person = new Person();

            switch (this.tsType){
                case Bus:
                    this.Park[i] = new Bus(person, (int)(Math.random() * 10));
                    break;
                case Tram:
                    this.Park[i] = new Tram(person, (int)(Math.random() * 10));
                    break;
                default:
                    break;
            }

        }
    }

    String getName() {
        return name;
    }

    String cost(){
        Integer ParkCost = 0;
        for(int i = 0; i < this.parkSize; i++){
            ParkCost += this.Park[i].VehicleCost;
        }
        return ParkCost.toString();
    }


    // пример самый простой
    String findVehicleByParams(String tsType, Integer VehicleCost){
        String Result = "Not compatible";
        Vehicle vehicle = null;

        // если параметр несоответствует типу парка
        if(!tsType.equals(this.tsType.toString())) return tsType + " " + Result;


        for(int i = 0; i < this.parkSize; i++){
            if(this.Park[i].VehicleCost.equals(VehicleCost)){
                vehicle = this.Park[i];
                break;
            }
        }
        Result = "Not found";
        if(vehicle != null){
            Result = tsType + " " + vehicle.serialNumber;
        }
        return Result;
    }


    void viewAll(){
        String leftAlignFormat = "| %-15s | %-4s | %-4d | %-4d |%n";
        System.out.format("+-----------------+------+------+------+%n");
        System.out.format("| Serial number   |tsType| Cost | Fuel |%n");
        System.out.format("+-----------------+------+------+------+%n");

        for(int i = 0; i < this.Park.length; i++){
            System.out.format(leftAlignFormat, this.Park[i].serialNumber, this.Park[i].tsType.toString() ,this.Park[i].VehicleCost, this.Park[i].getFuelConsumption());
        }
        System.out.format("+-----------------+------+------+------+%n");
    }

    public void fuelConsumptionAZ(){
        Arrays.sort(this.Park);
        this.viewAll();
    }

}
