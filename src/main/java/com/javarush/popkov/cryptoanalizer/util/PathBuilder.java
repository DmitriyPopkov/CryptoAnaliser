package com.javarush.popkov.cryptoanalizer.util;


import java.nio.file.*;

import com.javarush.popkov.cryptoanalizer.console.ConsoleApp;
import com.javarush.popkov.cryptoanalizer.constant.Const;



public class PathBuilder {

    public String filename;
 public Path inputFilePath;
    public PathBuilder(ConsoleApp application) {
        this.filename =application.filename;


this.inputFilePath=buildPath(application.filename);


    }


    public  Path buildPath(String filename) {

this.filename=filename;
        Path filePath = Path.of(Const.TXT_FOLDER + this.filename);


        System.out.println("Полный путь к файлу:" + filePath);

        FileValidator.validateForReading(filePath.toString());
        return filePath;
    }


}
