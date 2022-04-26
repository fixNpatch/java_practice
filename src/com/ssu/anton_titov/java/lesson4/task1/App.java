package com.ssu.anton_titov.java.lesson4.task1;

public class App {
    public static void main(String[] args) {
        App myApp = new App();
        myApp.start();
    }

    private void start() {

        // создать dynamicArray
        // add(T)
        // get(byIndex)
        // set(toPos, int)
        // remove(byIndex)
        // toString() = show all
        // constructor(setSize)
        // implement interface Iterable<T>


        DynamicArray<Integer> array = new DynamicArray<>(5);
        System.out.println(array);


        for(int i = 0; i < 5; i++) {
            array.add(i);
            System.out.println(array);
        }

        array.add(5);
        System.out.println(array);

        array.set(6, 7);
        System.out.println(array);


        array.remove(2);
        System.out.println(array);

    }
}