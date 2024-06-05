package src;

import src.filme.Filme;
import src.filme.IMDbBewertungen;
import src.personen.Regisur;
import src.personen.Schauspieler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
        }
        return 0;
    }


    private void handleLine(String line, ArrayList<Schauspieler> schauspielers, ArrayList<Filme> filme,ArrayList<Regisur> regisurs){
        if(line.contains("New_Entity")){
            groupnumber++;
            return;
        }
        //TODO WAS NICHT OFFENSICHTLICH IST DOPPELTE RAUS FILTERN
        switch (groupnumber){
            case 0:
                schauspielers.add(handleSchauspielerinput(line));
                break;
            case 1:
                filme.add(handleFilminput(line));
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }

    }


    private Schauspieler handleSchauspielerinput(String line){
        String[] lineparts = line.split("\",\"");
        //Anpassung der einzelen sting teile
        lineparts[0] = lineparts[0].substring(1);
        lineparts[0] = lineparts[0].trim();

        lineparts[1] = lineparts[1].substring(0, lineparts[1].length() - 1);
        lineparts[1] = lineparts[1].trim();
        try {
            return new Schauspieler(lineparts[1],Integer.parseInt(lineparts[0]));
        }catch (Exception e){
            System.err.println("Schauspieler : " + lineparts[0] + " Macht Probleme");
        }
        return null;
    }


    private Filme handleFilminput(String line){
        int size;
        String[] lineparts = line.split("\",\"");


        lineparts[0] =  lineparts[0].substring(1);
        size=lineparts.length;
        lineparts[size-1] = lineparts[size-1].substring(0, lineparts[size-1].length() - 1);

        for(int i = 0; i<size;i++){
            lineparts[i] = lineparts[i].trim();
        }

        try {
            if (size != 7) return new Filme(lineparts[1], lineparts[2], lineparts[4], Integer.parseInt(lineparts[0]));
            else return new Filme(lineparts[1], lineparts[2], lineparts[4], Integer.parseInt(lineparts[0]), new IMDbBewertungen(Double.parseDouble(lineparts[6]), Integer.parseInt(lineparts[5])));
        }catch (Exception e){
            System.err.println("Movie : " + lineparts[0] + " Macht Probleme");
        }
        return null;
    }
}
