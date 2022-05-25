package com.ssu.anton_titov.java.lesson6.task1;

import java.io.Serializable;

public abstract class BaseHomeAppliances implements Serializable {
    protected transient int power;
    protected transient int amperage;
    protected transient int resistance;
    protected String name;

    public BaseHomeAppliances(int power, int amperage, int resistance, String name) {
        this.power = power;
        this.amperage = amperage;
        this.resistance = resistance;
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public int getAmperage() {
        return amperage;
    }

    public int getResistance() {
        return resistance;
    }

    @Override
    public String toString() {
        return "{ " +
                "power=" + power +
                "; amperage=" + amperage +
                "; resistance=" + resistance +
                "; name=" + name +
                "} ";
    }
}
