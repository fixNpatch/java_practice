package com.ssu.anton_titov.java.lesson6.task1;

public class Kettle extends BaseHomeAppliances {
    public Kettle(int power, int amperage, int resistance) {
        super(power, amperage, resistance, "Kettle");
    }

    @Override
    public String toString() {
        return "Kettle" + super.toString();
    }
}
