package com.javarush.popkov.cryptoanalizer.util;

import com.javarush.popkov.cryptoanalizer.exeption.AppExeption;
import com.javarush.popkov.cryptoanalizer.util.FileValidator;
import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.*;

import com.javarush.popkov.cryptoanalizer.console.ConsoleApp;
import com.javarush.popkov.cryptoanalizer.constant.Const;

import java.util.List;

public class PathBuilder {
    /**
     * Метод для формирования пути к текстовому файлу.
     * @param fileName Имя файла (например, &quot;file.txt&quot;)
     * @return Полный путь к файлу.
     */
    public String filename;

    public PathBuilder(ConsoleApp application) {
        this.filename =application.filename;

        buildPath(this.filename);



    }


    public  Path buildPath(String filename) {

        // Получаем текущее рабочее директорию
        Path filePath = Path.of(Const.TXT_FOLDER + this.filename);
       // Path currentPath = Paths.get(";").toAbsolutePath();
        // Формируем полный путь

        System.out.println("Полный путь к файлу:" + filePath.toString());

      //  FileValidator.validateForReading(this.filename);
        return filePath.resolve(this.filename);
    }

    // public static void main(String[] args) {
        // Пример использования
      //  String fileName = ";example.txt&quot;; // Укажите имя вашего файла

       // Path filePath = buildPath(fileName);

      //  System.out.println("Полный путь к файлу:" + currentPath.toString());
   //
    /*
    public static final StandardOpenOption [] FILE_WRITE_OPTION={StandardOpenOption.CREATE,StandardOpenOption.APPEND};
    public String filename;

    public PathBuilder( String filename) {
        this.filename = filename;
    }

        public List<String> readFILE (String filename){

            try {
                Path filePath = Path.of(Const.TXT_FOLDER + this.filename);
                System.out.println(filePath);
                return Files.readAllLines(filePath);

            } catch (IOException | InvalidPathException ex) {
                throw new AppExeption(ex.getMessage());
            }
        }

    public void appendToFile(String filename,String content){
       try {

           Path filePath = Path.of(filename);
           Files.writeString(filePath, content, FILE_WRITE_OPTION);
       }catch (IOException ex){
           throw new AppExeption(ex.getMessage());
       }
    }

     */
}
