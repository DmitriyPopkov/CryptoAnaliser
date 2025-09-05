package com.javarush.popkov.cryptoanalizer.console;

import com.javarush.popkov.cryptoanalizer.command.Exit;
import com.javarush.popkov.cryptoanalizer.exeption.AppExeption;

import java.util.Scanner;

import static com.javarush.popkov.cryptoanalizer.console.Messages.outMode;

public class ConsoleApp {
    public  String filename;
    private  final Scanner scanner;
   public Menu inputmenu_Console;
   public int shift;

    public  ConsoleApp(Menu inputmenu,Scanner scanner) {
this.scanner=scanner;
        this.inputmenu_Console=inputmenu;
        if (inputmenu.inputmenu==3) {
            Exit.exit();
        }
            inputShift(inputmenu);





    }



    private String getinputPath() {

        this.filename=getScanner().nextLine();


        return  this.filename;
    }


   public Scanner getScanner() {
       return scanner;
   }

   public void  inputShift(Menu inputmenu){
       System.out.print("Введите имя файла для режима  "+ outMode[inputmenu.inputmenu]+"   " );
       this.filename =getinputPath();
       if (inputmenu.inputmenu!=2){
           String shift1;

           System.out.print("Введите ключ  ");
           shift1=getScanner().nextLine();
           try {

               this.shift=Integer.parseInt(shift1);
           } catch (NumberFormatException e) {
               throw new AppExeption(e.getMessage());
           }
       }else {
           this.shift=1;

       }

   }

}

