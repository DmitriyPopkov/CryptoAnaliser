package com.javarush.popkov.cryptoanalizer.controller;
import java.io.*;

import com.javarush.popkov.cryptoanalizer.command.BruteForce;
import com.javarush.popkov.cryptoanalizer.exeption.AppExeption;
import com.javarush.popkov.cryptoanalizer.command.Encode;
import com.javarush.popkov.cryptoanalizer.command.Decode;

import javax.imageio.IIOException;
import java.nio.file.Path;
import java.util.Set;

import static com.javarush.popkov.cryptoanalizer.constant.Const.*;
import static java.nio.file.Path.of;

public class MainController {
public int pick_upShift=0;
public int inputmenu_Main;
    public static int shift;
public Path readFILE;
    public Path outputFilePath;
    public MainController(Path inputFilePath,int shift,int inputmenu ) {
        String outputFilePath="";
this.inputmenu_Main=inputmenu;
      // int decodedShift =Encode.decodedShift;



       if (inputmenu==0) {
             outputFilePath = ENCRYPTED_PATH;

      }
       if ((inputmenu==1)) {
            outputFilePath = DECRYPTED_PATH;

        }
        if ((inputmenu==2)) {
            outputFilePath = BRUTFORCE_PATH;

        }

        this.readFILE=inputFilePath;
        MainController.shift=shift;
        this.outputFilePath= of(outputFilePath);

       try (BufferedReader reader = new BufferedReader(new FileReader(this.readFILE.toFile()));
           BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
           ;
           String line;
           while ((line = reader.readLine()) != null) {
               if ((inputmenu == 0)) {
                   String encryptedLine = Encode.encrypt(line, shift);
                   writer.write(encryptedLine);
               }
               if ((inputmenu == 1)) {
                   String decryptedLine = Decode.decrypt(line, shift);
                   writer.write(decryptedLine);
               }
               if ((inputmenu == 2)) {
                   String brutforcedLine = BruteForce.bruteforce(line, shift);
                   writer.write(brutforcedLine);
               }
               writer.newLine();


           }
           if ((inputmenu != 2)) {
               System.out.println("Шифрование завершено, результат сохранен в файле: " + outputFilePath);

           }


           } catch (IOException ex) {
           throw new AppExeption(ex.getMessage());
       }

        if ((inputmenu == 2)) {
            try {
                gotoAnaliz();
            } catch (IIOException e) {
                throw new AppExeption(e.getMessage());
            }
        }

    }

    public void gotoAnaliz() throws IIOException {
    Set<String> commonWordsBrutforce=BruteForce.findCommonWords();
         int commonEmtyWords=commonWordsBrutforce.size();
         if (commonEmtyWords>35) {
              System.out.println("Взлом завершен, ключ: " + shift);
             System.out.println("Результат сохранен в файле: " + outputFilePath);
             this.pick_upShift=0;
            System.exit(0);
          }else {
             MainController.shift=BruteForce.bruteforceShift(shift);
             this.pick_upShift=1;
         }
    }


}
