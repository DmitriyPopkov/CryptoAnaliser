package com.javarush.popkov.cryptoanalizer.constant;

import java.io.File;

public interface Const {
    String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;

String ENCRYPTED_PATH="C:\\Users\\Administrator\\IdeaProjects\\CryptoAnalizer\\CryptoAnalizer\\text\\encryptedText.txt";
    String DECRYPTED_PATH="C:\\Users\\Administrator\\IdeaProjects\\CryptoAnalizer\\CryptoAnalizer\\text\\decryptedText.txt";
    String METRIKA_PATH="C:\\Users\\Administrator\\IdeaProjects\\CryptoAnalizer\\CryptoAnalizer\\text\\metrika.txt";
    String BRUTFORCE_PATH="C:\\Users\\Administrator\\IdeaProjects\\CryptoAnalizer\\CryptoAnalizer\\text\\brutforsText.txt";
}
