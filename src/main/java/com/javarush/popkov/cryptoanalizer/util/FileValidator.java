package com.javarush.popkov.cryptoanalizer.util;

import com.javarush.popkov.cryptoanalizer.exeption.AppExeption;


import java.io.File;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;




public class FileValidator {
    private static final List<String> FORBIDDEN_DIRS_FILES =
            List.of(".bash_history", ".bash_profile", "etc", "proc");


    public static void validateForWriting(String filename) {

        Path path = validatePath(filename);
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                throw new AppExeption("Файл является каталогом");
            }
            if (!Files.isWritable(path)) {
                throw new AppExeption("Файл не доступен для записи");
            }
        }
    }

    public static void validateForReading(String filename) {

        Path path = validatePath(filename);
        if (Files.notExists(path)) {

            throw new AppExeption("Файла не существует");
        }
        if (Files.isDirectory(path)) {
            throw new AppExeption("Файл является каталогом");
        }
        if (!Files.isReadable(path)) {
            throw new AppExeption("Файл не доступен для чтения");
        }

    }

    private static Path validatePath(String filename) {
        File fileName = new File(filename);
        String fileName1 = fileName.getName();
        Path fileName2;
        String fileName3;
        int lastIndexOfDot = fileName1.lastIndexOf(".");
        if (lastIndexOfDot > 0 && lastIndexOfDot < fileName.length() - 1) {
            fileName2 = Path.of(fileName1.substring(lastIndexOfDot + 1));
            fileName3 = fileName2.toString();
            if (FORBIDDEN_DIRS_FILES.contains(fileName3)) {
                throw new AppExeption("Имя содержит запрещенную часть : " + filename);
            }
        }



            try {

                return Path.of(filename);
            } catch (InvalidPathException ex) {
                throw new AppExeption("Некорректный путь" + ex.getMessage());
            }


        }


}