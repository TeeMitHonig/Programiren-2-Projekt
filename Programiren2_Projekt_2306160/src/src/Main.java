package src;

import src.filme.Filme;
import src.personen.Regisur;
import src.personen.Schauspieler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static src.Datahelper.*;


public class Main {
    public static void main(String[] args) {



        ArrayList<Filme> filme = new ArrayList<>();
        ArrayList<Regisur> regisure = new ArrayList<>();
        ArrayList<Schauspieler> schauspieler = new ArrayList<>();
        String filepath = ".//movieproject2024.db";

        Reader reader = new Reader();
        reader.read(filepath,filme,regisure,schauspieler);

        String[] argument = "--schauspielernetzwerk=17562".split("="); //args[0].split("=");

        switch (argument[0]){
            case "--filmsuche":
                filmsuche(argument[1],filme);
                break;
            case "--schauspielersuche":
                schauspilersuche(argument[1],schauspieler);
                break;

            case "--filmnetzwerk":
                showFilmnetzwerk(Integer.parseInt(argument[1]),filme);
                break;

            case "--schauspielernetzwerk":
                schowSchauspilernetztwerk(Integer.parseInt(argument[1]),schauspieler);
                break;




    }

}

private static void filmsuche(String suche, ArrayList<Filme> filme){
    ArrayList<Filme> gefundenefilme =findByString(suche,filme,Filme::getTitel);
    for (Filme f:gefundenefilme)
        System.out.println(f.getId() + "\n" + f.getTitel() + "\n" + f.getBeschreibung() + "\n");


}

private static void schauspilersuche(String suche,ArrayList<Schauspieler> schauspielers){
    ArrayList<Schauspieler> gefundeneschauspielr = findByString(suche,schauspielers,Schauspieler::getName);
    for(Schauspieler s : gefundeneschauspielr) System.out.println(s.getId() + "\n" + s.getName() + "\n");

}

private static void showFilmnetzwerk(int id, ArrayList<Filme>filmelist){
    ArrayList<Filme> filme = new ArrayList<>();
    ArrayList<Schauspieler> schauspieler = new ArrayList<>();
        findnetzwerk(findByID(id,filmelist,Filme::getId),filme,schauspieler);

        System.out.print("Schauspieler: " );
        for (Schauspieler s:schauspieler){
            System.out.print(s.getName() + ", ");
        }
        System.out.print("\nFilme: ");
       for (Filme f:filme){
           System.out.print(f.getTitel() + ", ");
       }

    }

    private static void schowSchauspilernetztwerk(int id, ArrayList<Schauspieler>schauspielerlist){
        ArrayList<Filme> filme = new ArrayList<>();
        ArrayList<Schauspieler> schauspieler = new ArrayList<>();
        findSchauspilernetzwerk(findByID(id,schauspielerlist, Schauspieler::getId),schauspieler,filme);

        System.out.print("Schauspieler: " );
        for (Schauspieler s:schauspieler){
            System.out.print(s.getName() + ", ");
        }
        System.out.print("\nFilme: ");
        for (Filme f:filme){
            System.out.print(f.getTitel() + ", ");
        }

    }



}

