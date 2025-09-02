package com.javarush.popkov.cryptoanalizer.controller;

import com.javarush.popkov.cryptoanalizer.console.ConsoleApp;
import com.javarush.popkov.cryptoanalizer.util.PathBuilder;

import java.util.List;

public class MainController {
public ConsoleApp filename;

    public MainController(ConsoleApp filename){
        this.filename=filename;

       // PathBuilder readFILE=new PathBuilder(this.filename.filename);

    }
}
