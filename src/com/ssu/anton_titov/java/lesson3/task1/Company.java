package com.ssu.anton_titov.java.lesson3.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    private Vehicle[] park;
    private Integer parkSize;
    private TransportType tsType;


    Company(String companyName, CompanyType type, TransportType tsType , Integer parkSize) throws BadParams, IOException {
        try {

            System.out.println(companyName);

            if (parkSize < 0){
                throw new ParkSizeLessThenZero("park size cannot be less then 0.");
            }


            if (companyName.length() <= 0){
                throw new EmptyName("Company name cannot be empty.");
            }

            this.type = type;
            this.name = companyName;
            this.tsType = tsType;
            this.parkSize = parkSize;
            this.park = new Vehicle[parkSize];
            System.out.println(this.park.length);
            List<String> lines;

            // try with resources
            try(BufferedReader reader
                        = new BufferedReader(
                    new FileReader(Paths.get(".","resources", "test.txt").toFile())
            )
            ){
                lines = reader.lines().collect(Collectors.toList());
                createPark(lines);

            } catch (IOException e){
                throw e;
            }


        } catch (BadParams | IOException e){
            System.out.println("Exception on creating company:" + e);
            throw e;
        } finally {
            System.out.println("New attempt to create company completed");
        }
    }



    private void createPark(List<String> possibleNames){
        for(int i = 0; i < this.park.length; i++){
            switch (this.tsType){
                case Bus:
                    this.park[i] = new Bus(new Person(""), (int)(Math.random() * 10));
                    break;
                case Tram:
                    this.park[i] = new Tram(new Person(""), (int)(Math.random() * 10));
                    break;
            }
        }
    }

    private String getName() {
        return name;
    }


    void viewAll(){
        String leftAlignFormat = "| %-15s | %-4s | %-4d | %-4d |%n";
        System.out.format("+-----------------+------+------+------+%n");
        System.out.format("| Serial number   |tsType| Cost | Fuel |%n");
        System.out.format("+-----------------+------+------+------+%n");

        for (Vehicle vehicle : this.park) {
            System.out.format(leftAlignFormat, vehicle.serialNumber, vehicle.tsType.toString(), vehicle.vehicleCost, vehicle.getFuelConsumption());
        }
        System.out.format("+-----------------+------+------+------+%n");
    }

    public void fuelConsumptionAZ(){
        Arrays.sort(this.park);
        this.viewAll();
    }

}
