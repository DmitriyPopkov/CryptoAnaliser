package com.javarush.popkov.cryptoanalizer;
import java.io.PrintStream;
import com.javarush.popkov.cryptoanalizer.controller.MainController;
import com.javarush.popkov.cryptoanalizer.console.ConsoleApp;
import com.javarush.popkov.cryptoanalizer.console.Menu;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        //build console app
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu(input);

      //  MainController mainController = new MainController();
      //  ConsoleApp application = new ConsoleApp(mainController, menu);
        //run console app
      //  application.run(args);
    }


}

