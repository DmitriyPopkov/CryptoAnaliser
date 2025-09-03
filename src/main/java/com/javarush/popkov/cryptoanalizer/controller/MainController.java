package com.javarush.popkov.cryptoanalizer.controller;
import java.io.*;

import com.javarush.popkov.cryptoanalizer.console.ConsoleApp;
import com.javarush.popkov.cryptoanalizer.util.PathBuilder;
import com.javarush.popkov.cryptoanalizer.exeption.AppExeption;
import com.javarush.popkov.cryptoanalizer.command.Encode;
import com.javarush.popkov.cryptoanalizer.command.Decode;
import java.nio.file.Path;
import java.util.List;
import  com.javarush.popkov.cryptoanalizer.console.Menu;
import static com.javarush.popkov.cryptoanalizer.constant.Const.ENCRYPTED_PATH;
import static com.javarush.popkov.cryptoanalizer.constant.Const.DECRYPTED_PATH;
import static java.nio.file.Path.of;

public class MainController {

public int inputmenu_Main;
    public int shift;
public Path readFILE;
    public Path outputFilePath;
    public MainController(Path inputFilePath,int shift,int inputmenu ){
        String outputFilePath="";
this.inputmenu_Main=inputmenu;
       int decodedShift =Encode.decodedShift;



       if (inputmenu==0) {
             outputFilePath = ENCRYPTED_PATH;

      }
       if ((inputmenu==1)) {
            outputFilePath = DECRYPTED_PATH;

        }

        this.readFILE=inputFilePath;
        this.shift=shift;
        this.outputFilePath= of(outputFilePath);

       try (BufferedReader reader = new BufferedReader(new FileReader(this.readFILE.toFile()));
           BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath)))  {    ;
           String line;
           while ((line = reader.readLine()) != null)

               {
                   if ((inputmenu==0)) {
                       String encryptedLine = Encode.encrypt(line, shift);
                       writer.write(encryptedLine);
                   }
                   if ((inputmenu==1)) {
                       String decryptedLine = Decode.decrypt(line, shift,decodedShift);
                       writer.write(decryptedLine);
                   }
                   writer.newLine();


               }
           System.out.println("Шифрование завершено, результат сохранен в файле: " + outputFilePath);
                    } catch (IOException e ) {
           throw new AppExeption(e.getMessage());
       }

    }

}
