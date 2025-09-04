package com.javarush.popkov.cryptoanalizer.command;

import com.javarush.popkov.cryptoanalizer.constant.Const;
import com.javarush.popkov.cryptoanalizer.exeption.AppExeption;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BruteForce {
    public static boolean commonEmtyWords;
    public static int bruteforceShift;

    public static String bruteforce(String text, int shift) {

        return Encode.encrypt(text, (-1 * shift));

    }
    // Метод для нахождения общих слов в двух файлах

    public static Set<String> findCommonWords() throws IIOException {
        Set<String> wordsInFile1_buff = BruteForce.findCommonWords1();
        Set<String> commonWords_buff = BruteForce.findCommonWords2(wordsInFile1_buff);
        BruteForce.commonEmtyWords = commonWords_buff.isEmpty();
        return commonWords_buff;
    }

    public static Set<String> findCommonWords1() throws IIOException {
        Set<String> wordsInFile1 = new HashSet<>();
        // Чтение первого файла и добавление слов в множество
        try (BufferedReader reader1 = new BufferedReader(new FileReader(Const.METRIKA_PATH))) {
            String line;
            while ((line = reader1.readLine()) != null) {

                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordsInFile1.add(word.toLowerCase()); // Добавление в множество в нижнем регистре для нечувствительности к регистру
                }
            }
        } catch (IOException e) {
            throw new AppExeption(e.getMessage());
        }
        return wordsInFile1;
    }

    public static Set<String> findCommonWords2(Set<String> wordsInFile1) throws IIOException {
        Set<String> commonWords = new HashSet<>();

        try (BufferedReader reader2 = new BufferedReader(new FileReader(Const.BRUTFORCE_PATH))) {
            String line;
            while ((line = reader2.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (wordsInFile1.contains(word.toLowerCase())) {
                        commonWords.add(word.toLowerCase());
                    }
                }
            }

        } catch (IOException e) {
            throw new AppExeption(e.getMessage());
        }

        return commonWords;
    }

    public static int bruteforceShift(int shift) {
        ++shift;
        return shift;
    }

}