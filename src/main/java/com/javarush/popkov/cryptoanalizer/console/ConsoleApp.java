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
   public   Menu inputmenu;
   public int shift;

    public  ConsoleApp(Menu inputmenu,Scanner scanner) {
this.scanner=scanner;
        this.inputmenu=inputmenu;



        System.out.print("Введите имя файла для режима  "+ outMode[this.inputmenu.INPUTMENU]+"   " );
        this.filename =getinputPath();
if (this.inputmenu.INPUTMENU!=3){
    String shift1;

    System.out.print("Введите ключ  ");
    shift1=getScanner().nextLine();
    try {
        this.shift=Integer.parseInt(shift1);

    } catch (NumberFormatException e) {
        throw new AppExeption(e.getMessage());
    }
}
    }



    private String getinputPath() {

        this.filename=getScanner().nextLine();


        return  this.filename;
    }


   public Scanner getScanner() {
       return scanner;
   }

}

