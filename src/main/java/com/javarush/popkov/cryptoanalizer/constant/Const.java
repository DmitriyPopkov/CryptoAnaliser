package com.javarush.popkov.cryptoanalizer.constant;

import java.io.File;

import static java.lang.System.getProperty;

public interface Const {
    String TXT_FOLDER = getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;

String ENCRYPTED_PATH=TXT_FOLDER+"encryptedText.txt";
    String DECRYPTED_PATH=TXT_FOLDER+"decryptedText.txt";
    String METRIKA_PATH=TXT_FOLDER+"metrika.txt";
    String BRUTFORCE_PATH=TXT_FOLDER+"brutforsText.txt";
}
