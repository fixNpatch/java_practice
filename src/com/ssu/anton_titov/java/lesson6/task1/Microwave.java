package com.ssu.anton_titov.java.lesson6.task1;

public class Microwave extends BaseHomeAppliances {
    public Microwave(int power, int amperage, int resistance) {
        super(power, amperage, resistance, "Microwave");
    }

    @Override
    public String toString() {
        return "Microwave" + super.toString();
    }
}
