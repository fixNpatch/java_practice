package com.ssu.anton_titov.java.lesson5.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {


        var res = Stream.generate(new Random()::nextInt)
                .filter(value -> value > 0 && value < 1000000)
                .limit(100)
                .filter(value -> value % 2 == 0)
                .map(value -> value * 2)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .peek(System.out::println)
                .reduce(0, Integer::sum)
                .toString();

        System.out.println("sum : " + res);

    }
}
