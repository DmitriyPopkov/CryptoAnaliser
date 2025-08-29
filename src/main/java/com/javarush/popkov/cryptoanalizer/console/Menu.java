package com.javarush.popkov.cryptoanalizer.console;
import java.util.Scanner;

import com.javarush.popkov.cryptoanalizer.ConsoleRunner;
import com.javarush.popkov.cryptoanalizer.command.Encode;
import com.javarush.popkov.cryptoanalizer.command.Decode;
import com.javarush.popkov.cryptoanalizer.command.Exit;
import static com.javarush.popkov.cryptoanalizer.console.Messages.*;

public class Menu {
    public   final int INPUTMENU;

    private static Scanner scanner;

    public Menu(Scanner input) {
        String inputmode;
        int mode;
            System.out.println(EncodeMenu + "  1");
            System.out.println(DecodeMenu + "  2");
            System.out.println(ExitMenu + "  3");
            System.out.print("Выбран режим  ");
do{
    inputmode = input.nextLine();


            mode = switch (inputmode) {
                case "1" -> 0;
                case "2" -> 1;
                case "3" -> 2;
                // case "4" -> 4;
                // case "5" -> 4;
                default -> {

                    System.out.println("INCORRECT_SELECTION");

                    yield -1;

                }
            };


        } while (mode < 0) ;

        this.INPUTMENU=mode;
        System.out.println(outMode[mode]);
        }

    }
