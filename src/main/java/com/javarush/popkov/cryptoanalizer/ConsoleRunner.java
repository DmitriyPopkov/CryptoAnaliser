package com.javarush.popkov.cryptoanalizer;
import com.javarush.popkov.cryptoanalizer.console.Menu;
import com.javarush.popkov.cryptoanalizer.controller.MainController;
import com.javarush.popkov.cryptoanalizer.util.FileValidator;
import com.javarush.popkov.cryptoanalizer.util.PathBuilder;
import com.javarush.popkov.cryptoanalizer.console.ConsoleApp;

import java.nio.file.Path;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        //build console app
        Scanner input = new Scanner(System.in);
        Menu inputmenu= new Menu(input);
        ConsoleApp application = new ConsoleApp(inputmenu,input);
        PathBuilder readFILE= new PathBuilder(application);


      MainController mainController = new MainController(readFILE.inputFilePath,application.shift);
      //  ConsoleApp application = new ConsoleApp(mainController, menu);
        //run console app
      //  application.run(args);
    }


}

