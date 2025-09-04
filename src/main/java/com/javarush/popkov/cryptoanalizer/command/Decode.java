package com.javarush.popkov.cryptoanalizer.command;
import com.javarush.popkov.cryptoanalizer.controller.MainController;
import com.javarush.popkov.cryptoanalizer.command.Encode;
public class Decode {

    public static String decrypt(String text, int shift) {

        return Encode.encrypt(text, (-1*shift)); // Декодирование является шифрованием с отрицательным сдвигом
    }
}
