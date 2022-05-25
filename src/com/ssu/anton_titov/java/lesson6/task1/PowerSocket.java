package com.ssu.anton_titov.java.lesson6.task1;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class PowerSocket implements Serializable {
    private final List<BaseHomeAppliances> homeAppliances;

    public PowerSocket(List<BaseHomeAppliances> homeAppliances) {
        this.homeAppliances = homeAppliances;
    }

    public int fullPower() {
        int result = 0;
        for (BaseHomeAppliances homeAppliance : homeAppliances) {
            result += homeAppliance.getPower();
        }
        return result;
    }

    public void sort() {
        homeAppliances.sort(new Comparator<BaseHomeAppliances>() {
            @Override
            public int compare(BaseHomeAppliances o1, BaseHomeAppliances o2) {
                return Integer.compare(o1.getResistance(), o2.getResistance());
            }
        });
    }

    public BaseHomeAppliances find(int minAmperage,
                                int maxAmperage,
                                int minResistance,
                                int maxResistance) {
        for (BaseHomeAppliances homeAppliance : homeAppliances) {
            if (homeAppliance.getAmperage() >= minAmperage
                    && homeAppliance.getAmperage() <= maxAmperage
                    && homeAppliance.getResistance() >= minResistance
                    && homeAppliance.getResistance() <= maxResistance) {
                return homeAppliance;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (BaseHomeAppliances homeAppliance : homeAppliances) {
            builder.append(homeAppliance.toString());
            builder.append('\n');
        }
        return builder.toString();
    }
}
