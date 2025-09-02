package com.javarush.popkov.cryptoanalizer.controller;
import java.io.*;

import com.javarush.popkov.cryptoanalizer.console.ConsoleApp;
import com.javarush.popkov.cryptoanalizer.util.PathBuilder;
import com.javarush.popkov.cryptoanalizer.exeption.AppExeption;

import java.nio.file.Path;
import java.util.List;

public class MainController {
public Path readFILE;
    public Path outputFilePath;
    public MainController(Path inputFilePath){
        String outputFilePath="C:\\Users\\Administrator\\IdeaProjects\\CryptoAnalizer\\CryptoAnalizer\\text\\logs.txt";
        this.readFILE=inputFilePath;
this.outputFilePath=Path.of(outputFilePath);

       try (BufferedReader reader = new BufferedReader(new FileReader(this.readFILE.toFile()));
           BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath)))  {    ;
           String line;
           while ((line = reader.readLine()) != null)

               {
                   // String encryptedLine = encrypt(line, shift);
                   writer.write(line);
                   writer.newLine();
                   // System.out.println(filePath);
                   // return Files.readAllLines(filePath);

               }
           System.out.println("Шифрование завершено, результат сохранен в файле: " + outputFilePath);
                    } catch (FileNotFoundException e) {
           throw new AppExeption(e.getMessage());
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }
}
