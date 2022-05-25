package com.ssu.anton_titov.java.lesson6.task1;

public class CoffeeMachine extends BaseHomeAppliances {
    public CoffeeMachine(int power, int amperage, int resistance) {
        super(power, amperage, resistance, "CoffeeMachine");
    }

    @Override
    public String toString() {
        return "CoffeeMachine" + super.toString();
    }
}
