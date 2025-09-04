package com.javarush.popkov.cryptoanalizer.console;

import java.util.Scanner;

import com.javarush.popkov.cryptoanalizer.command.Encode;
import com.javarush.popkov.cryptoanalizer.console.Menu;
import com.javarush.popkov.cryptoanalizer.controller.MainController;
import com.javarush.popkov.cryptoanalizer.exeption.AppExeption;

import static com.javarush.popkov.cryptoanalizer.console.Messages.outMode;

public class ConsoleApp {
    public  String filename;
    private  final Scanner scanner;
   public   Menu inputmenu_Console;
   public int shift;

    public  ConsoleApp(Menu inputmenu,Scanner scanner) {
this.scanner=scanner;
        this.inputmenu_Console=inputmenu;

            inputShift(inputmenu);




        if (inputmenu.inputmenu==3) {
            System.exit(0);
        }
    }



    private String getinputPath() {

        this.filename=getScanner().nextLine();


        return  this.filename;
    }


   public Scanner getScanner() {
       return scanner;
   }

   public int inputShift(Menu inputmenu){
       System.out.print("Введите имя файла для режима  "+ outMode[inputmenu.inputmenu]+"   " );
       this.filename =getinputPath();
       if (inputmenu.inputmenu!=2){
           String shift1;

           System.out.print("Введите ключ  ");
           shift1=getScanner().nextLine();
           try {
               // this.shift=((32 - Integer.parseInt(shift1)) % 32);
               this.shift=Integer.parseInt(shift1);
           } catch (NumberFormatException e) {
               throw new AppExeption(e.getMessage());
           }
       }else {
           this.shift=1;

       }
           return shift;
   }

}

