package com.ssu.anton_titov.java.lesson2.task1;

public class Person {
    private String firstName, secondName, middleName;
    private String Telephone;
    private Integer Experience;

    public String getInfo(){
        return this.secondName + " " + this.firstName + " " + this.middleName + ". Experienced with " +
                this.Experience + " years. Tel: " + this.Telephone;
    }
}
