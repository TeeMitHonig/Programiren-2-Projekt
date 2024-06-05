package src;

import src.filme.Filme;
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
            if((line = reader.readLine()) != null) {
                handleLine(line);
            }
        } catch (IOException e) {
            System.err.println("Problem beim Lesen der Datei");
        }catch (Exception e){
            System.err.println("Ein unbekannter Fehler ist aufgetreten");
        }
        return 0;
    }


    private void handleLine(String line){
        if(line.contains("NewEntity")){
            groupnumber++;
        }
        switch (groupnumber){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }

    }



















































    

    private  void readSchauspieler(BufferedReader reader, ArrayList<Schauspieler> schauspieler) throws IOException {
        String line;
        while ((line = reader.readLine()) != null && !line.contains("New_Entity")){

        }

    }

    private  void readFilme(BufferedReader reader, ArrayList<Filme> filme) throws IOException {
        String line;
        while ((line = reader.readLine()) != null && !line.contains("New_Entity")){

        }

    }

    private  void readRegisur(BufferedReader reader, ArrayList<Regisur> regisur) throws IOException {
        String line;
        while ((line = reader.readLine()) != null && !line.contains("New_Entity")){

        }
    }

    private  void readSchauspielerFilme(BufferedReader reader, ArrayList<Schauspieler> schauspieler, ArrayList<Filme> filme) throws IOException {
        String line;
        while ((line = reader.readLine()) != null && !line.contains("New_Entity")){

        }
    }

    private  void readRegisurFilme(BufferedReader reader, ArrayList<Regisur> regisur, ArrayList<Filme> filme) throws IOException {
        String line;
        while ((line = reader.readLine()) != null && !line.contains("New_Entity")){

        }
    }
}
