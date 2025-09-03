package com.javarush.popkov.cryptoanalizer.command;
import com.javarush.popkov.cryptoanalizer.controller.MainController;
import com.javarush.popkov.cryptoanalizer.command.Encode;
public class Decode {
   static int decodedShift;
    public static String decrypt(String text, int shift,int decodedShift) {
        Decode.decodedShift=decodedShift;
        return Encode.encrypt(text, (-1*shift)); // Декодирование является шифрованием с отрицательным сдвигом
    }
}
