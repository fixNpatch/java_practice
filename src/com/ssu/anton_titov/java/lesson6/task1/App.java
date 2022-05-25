package com.ssu.anton_titov.java.lesson6.task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        App application = new App();
        application.startApplication();
    }

    public void startApplication() throws Exception {
        List<BaseHomeAppliances> appliances = new ArrayList<>();
        appliances.add(new Kettle(100, 100, 100));
        appliances.add(new Microwave(100, 100, 100));
        appliances.add(new CoffeeMachine(100, 100, 100));
        PowerSocket powerSocket = new PowerSocket(appliances);

        try (ObjectOutputStream output =
                     new ObjectOutputStream(new FileOutputStream("lesson_06_task_01.txt"))) {
            output.writeObject(powerSocket);
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(new FileInputStream("lesson_06_task_01.txt"))) {
            PowerSocket powerSocket1 = (PowerSocket) input.readObject();
            System.out.println(powerSocket1);
        }
    }
}
