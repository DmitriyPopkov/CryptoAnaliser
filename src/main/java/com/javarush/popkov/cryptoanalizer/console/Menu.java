package com.javarush.popkov.cryptoanalizer.console;
import java.util.Scanner;
import com.javarush.popkov.cryptoanalizer.console.ConsoleApp;
import static com.javarush.popkov.cryptoanalizer.console.Messages.*;

public class Menu {

    public static Scanner scanner;
   public  int INPUTMENU;




    public Menu(Scanner input) {
        int mode;
        this.scanner=input;
        String inputmode;

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

        System.out.println(outMode[mode]);
this.INPUTMENU=mode;
        }
/*
    public int getINPUTMENU() {

        return this.INPUTMENU;
    }
*/

}
