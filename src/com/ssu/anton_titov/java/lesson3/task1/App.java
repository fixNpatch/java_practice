package com.ssu.anton_titov.java.lesson3.task1;

public class App {
    public static void main(String[] args) {
        App myApp = new App();
        myApp.start();
    }

    private void start() {

        Company firstCompany = null;
        Company secondCompany = null;
        Company thirdCompany = null;

        try{
            firstCompany = new Company("СарАвтобус",
                    CompanyType.Private, TransportType.Bus, 3); // Физ и юр лица


            secondCompany = new Company("СарЭлектроТранс",
                    CompanyType.Municipal, TransportType.Tram, -10); // принадлежащие городу


        }catch (Exception e){
            System.out.println("Caught on App::Start::" + e);
        } finally {
            firstCompany.viewAll();

            System.out.println("Company creation completed.");
        }

    }
}