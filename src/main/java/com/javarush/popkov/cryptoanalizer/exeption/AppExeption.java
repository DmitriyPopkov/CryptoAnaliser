package com.javarush.popkov.cryptoanalizer.exeption;

public class AppExeption extends RuntimeException {
    public AppExeption(String message) {
        super(message);
    }
}
