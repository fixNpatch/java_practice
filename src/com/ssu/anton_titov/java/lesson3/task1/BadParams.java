package com.ssu.anton_titov.java.lesson3.task1;

public class BadParams extends Exception {
    BadParams(String errorMessage){
        super(errorMessage);
    }
}
