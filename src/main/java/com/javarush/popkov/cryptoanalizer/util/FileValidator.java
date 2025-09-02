package com.javarush.popkov.cryptoanalizer.util;

import com.javarush.popkov.cryptoanalizer.exeption.AppExeption;
import com.javarush.popkov.cryptoanalizer.util.PathBuilder;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;

import static java.lang.System.getProperty;

public class FileValidator {
    private static final List<String> FORBIDDEN_DIRS_FILES =
            List.of(".bash_history", ".bash_profile", "etc", "proc");
    public static final String SYSTEM_SEPARATOR = FileSystems.getDefault().getSeparator();
    public String filename;

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
        for (String pathPart : filename.split(SYSTEM_SEPARATOR)) {
            /*
            if (FORBIDDEN_DIRS_FILES.contains(pathPart)) {
                throw new AppExeption("Путь содержит запрещенную часть:" + pathPart);
            }
        }
        try{
            return Path.of(filename);
    }catch (InvalidPathException ex){
            throw new AppExeption("Некорректный путь"+ex.getMessage());
        }
*/
            System.out.println(pathPart);

        }
        return Path.of(filename);
    }
}