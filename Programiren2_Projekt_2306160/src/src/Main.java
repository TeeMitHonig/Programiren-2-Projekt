package src;

import src.filme.Filme;
import src.personen.Regisur;
import src.personen.Schauspieler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//TODO GESCHEITE RELAZIONEN
//TODO Einlesen
//TODO Funkzionalitätä
public class Main {
    public static void main(String[] args) {



        ArrayList<Filme> filme = new ArrayList<>();
        ArrayList<Regisur> regisure = new ArrayList<>();
        ArrayList<Schauspieler> schauspieler = new ArrayList<>();
        String filepath = ".//movieproject2024.db";

        Reader reader = new Reader();
        reader.read(filepath,filme,regisure,schauspieler);

        String[] argument = args[0].split("=");

        switch (argument[0]){
            case "--filmsuche":

                break;
            case "--schauspielersuche":

                break;

            case "--filmnetzwerk":
                break;

            case "--schauspielernetzwerk":
                break;


        }


        System.out.println("Fertig ");
    }



}

