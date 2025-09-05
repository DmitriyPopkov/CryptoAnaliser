package com.javarush.popkov.cryptoanalizer.command;




import static com.javarush.popkov.cryptoanalizer.constant.Alphabet.*;

public class Encode {


    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            encryptedText.append(encryptCharacter(character, shift));
        }

        return encryptedText.toString();
    }

    private static char encryptCharacter(char character, int shift) {

        if (( character >='a' && character <='z')||( character >='A' && character <='Z')) {

            if (Character.isLowerCase(character)) {

                return encryptInAlphabet(character, LATIN_ALPHABET, shift);
            } else if (Character.isUpperCase(character)) {

                return encryptInAlphabet(Character.toLowerCase(character), LATIN_ALPHABET, shift);
            }
        }

            if ( character >='а' && character <='я')

       {

            return encryptInAlphabet(character, RUSSIAN_ALPHABET, shift);
        } else
            if ( character >='А' && character <='Я'){
            return encryptInAlphabet(character, RUSSIAN_ALPHABET_UPPER, shift);
        }

        return encryptInAlphabet(character, SYMBOLS, shift);
    }

    private static char encryptInAlphabet(char character, char[] alphabet, int shift) {
        int index = -1;


        for (int i = 0; i< alphabet.length ;i++){
            if (alphabet[i] == character) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            int newIndex = (index + shift) % alphabet.length;
            return alphabet[(newIndex + alphabet.length) % alphabet.length];
        }


        return character;
    }

}
