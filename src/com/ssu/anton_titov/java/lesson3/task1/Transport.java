package com.ssu.anton_titov.java.lesson3.task1;


interface PublicTransport {
    void pickPassengersUp(Integer amount);
    void dropPassengersOff(Integer amount);
}

interface Transport {
    void stop();
    void move();
    void engineOn();
    void engineOff();
    Integer getFuelConsumption();
}
