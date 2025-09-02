package com.javarush.popkov.cryptoanalizer.console;

import java.util.Scanner;
import com.javarush.popkov.cryptoanalizer.console.Menu;
import com.javarush.popkov.cryptoanalizer.controller.MainController;
import static com.javarush.popkov.cryptoanalizer.console.Messages.outMode;

public class ConsoleApp {
    public  String filename;
    private  final Scanner scanner;
   public   Menu inputmenu;

    public  ConsoleApp(Menu inputmenu,Scanner scanner) {
this.scanner=scanner;
        this.inputmenu=inputmenu;



        System.out.print("Введите имя файла для режима  "+ outMode[this.inputmenu.INPUTMENU]+"   " );
        this.filename =getinputPath();

    }



    private String getinputPath() {

        this.filename=getScanner().nextLine();


        return  this.filename;
    }


   public Scanner getScanner() {
       return scanner;
   }

}

