package src;

import src.filme.Filme;
import src.filme.IMDbBewertungen;
import src.personen.Regisur;
import src.personen.Schauspieler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import static src.Datahelper.addIfNotDuplicate;
import static src.Datahelper.findByID;


public class Reader {
    private int groupnumber;


    public  int read(String filePath, ArrayList<Filme> filme , ArrayList<Regisur> regisure , ArrayList<Schauspieler> schauspieler ) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            groupnumber=0;
            String line;
            reader.readLine(); //Die erste zeile ignoreien
            while ((line = reader.readLine()) != null) {
                handleLine(line,schauspieler,filme,regisure);
            }
        } catch (IOException e) {
            System.err.println("Problem beim Lesen der Datei");
        }catch (Exception e){
            System.err.println("Ein unbekannter Fehler ist aufgetreten");
            e.printStackTrace();
        }
        return 0;
    }


    private void handleLine(String line, ArrayList<Schauspieler> schauspieler, ArrayList<Filme> filme,ArrayList<Regisur> regisur){
        if(line.contains("New_Entity")){
            groupnumber++;
            return;
        }
        //TODO WAS NICHT OFFENSICHTLICH IST DOPPELTE RAUS FILTERN
        switch (groupnumber){
            case 0:
                Schauspieler s = handleSchauspielerinput(line);
                if(s != null)  addIfNotDuplicate(schauspieler, s, Schauspieler::getId);
                break;
            case 1:
                Filme f = handleFilminput(line);
                if(f != null)  addIfNotDuplicate(filme, f, Filme::getId);
                break;
            case 2:
                Regisur r = handledirctorinput(line);
                if(r != null)  addIfNotDuplicate(regisur, r, Regisur::getId);
                break;
            case 3:
                addFilmSchauspilerbezihung(line,filme,schauspieler);
                break;
            case 4:
                addFilmRegisurbezihung(line,filme,regisur);
                break;
        }

    }


    private Schauspieler handleSchauspielerinput(String line){
        String[] lineparts = trimline(line);
        try {
            return new Schauspieler(lineparts[1],Integer.parseInt(lineparts[0]));
        }catch (Exception e){
            System.err.println("Schauspieler : " + lineparts[0] + " Macht Probleme");
        }
        return null;
    }

    //TODO EINGESCHEITESS DATUS FORMAT MAYBE
    private Filme handleFilminput(String line){
        int size;
        String[] lineparts = trimline(line);

        try {
            if (lineparts.length == 7 && !lineparts[6].isEmpty()) return new Filme(lineparts[1], lineparts[2], lineparts[4], Integer.parseInt(lineparts[0]), new IMDbBewertungen(Double.parseDouble(lineparts[6]), Integer.parseInt(lineparts[5])));
            else return new Filme(lineparts[1], lineparts[2], lineparts[4], Integer.parseInt(lineparts[0]));
        }catch (Exception e){
           // System.err.println("Movie : " + lineparts[0] + " Macht Probleme");
        }
        return null;
    }

    private Regisur handledirctorinput(String line){
        String[] lineparts = trimline(line);
        try {
            return new Regisur(lineparts[1],Integer.parseInt(lineparts[0]));
        }catch (Exception e){
            System.err.println("Regisur : " + lineparts[0] + " Macht Probleme");
        }
        return null;
    }


    private void addFilmSchauspilerbezihung(String line,ArrayList<Filme> filme,ArrayList<Schauspieler> schauspieler){
        String[] lineparts = trimline(line);
        Filme f = findByID(Integer.parseInt(lineparts[1]),filme,Filme::getId);
        Schauspieler s = findByID(Integer.parseInt(lineparts[0]), schauspieler, Schauspieler::getId);
        try {
            if (f != null && s != null) f.addBezihungSchauspieler(s);
        }catch (Exception e){
            System.err.println("Schuaspiler zu Film");
        }
    }



    private void addFilmRegisurbezihung(String line,ArrayList<Filme>filme,ArrayList<Regisur>regisur){
        String[] lineparts = trimline(line);
        Filme f = findByID(Integer.parseInt(lineparts[1]),filme,Filme::getId);
        Regisur r = findByID(Integer.parseInt(lineparts[0]), regisur, Regisur::getId);
        try {
            if (f != null && r != null) f.setRegisur(r);
        }catch (Exception e){
            System.out.println("Regisures zu Filmen " );
        }

    }

    private String[] trimline(String line){
        int size;
        String[] lineparts = line.split("\",\"");


        lineparts[0] =  lineparts[0].substring(1);
        size=lineparts.length;
        lineparts[size-1] = lineparts[size-1].substring(0, lineparts[size-1].length() - 1);

        for(int i = 0; i<size;i++){
            lineparts[i] = lineparts[i].trim();
        }
        return lineparts;
    }



}
