package com.javarush.popkov.cryptoanalizer.command;

public class Decode {

    public static String decrypt(String text, int shift) {

        return Encode.encrypt(text, (-1*shift));
    }
}
