package com.ssu.anton_titov.java.lesson2.task1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App myApp = new App();
        myApp.start();
    }

    private void start() {

        Company firstCompany = new Company("СарАвтобус",
                CompanyType.Private, TransportType.Bus, 3); // Физ и юр лица


        Company secondCompany = new Company("СарЭлектроТранс",
                CompanyType.Municipal, TransportType.Tram, 4); // принадлежащие городу

        secondCompany.viewAll();
        System.out.println(secondCompany.getName() + " costs " + secondCompany.cost()); // вывести стоимость парка транспортных средств


        System.out.println("\noriginal");
        firstCompany.viewAll(); // оригинал
        System.out.println("\n sorted");
        firstCompany.fuelConsumptionAZ(); // вывести отсортированные по расходу топлива ТС


        System.out.println("\nNow you're testing search in Exact(SecondCompany|Tram) company by some params");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Vehicle type");
        String vType;
        while (true) {
            vType = sc.next();
            if (vType.equals(TransportType.Bus.toString()) || vType.equals(TransportType.Tram.toString())) {
                break;
            }
            System.out.println("Incorrect. Try again");
        }

        System.out.println("Enter vehicle cost");
        Integer vCost = sc.nextInt();

        System.out.println(secondCompany.findVehicleByParams(vType, vCost)); // найти ТС по параметрам

    }
}