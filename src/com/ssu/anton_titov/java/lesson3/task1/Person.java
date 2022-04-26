package com.ssu.anton_titov.java.lesson3.task1;

public class Person {
    private String firstName, secondName, middleName;
    private String telephone;
    private Integer experience;

    Person(String firstName){
        this.firstName = firstName;
    }

    public String getInfo(){
        return this.secondName + " " + this.firstName + " " + this.middleName + ". Experienced with " +
                this.experience + " years. Tel: " + this.telephone;
    }
}
