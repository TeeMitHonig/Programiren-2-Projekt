package src.filme;

import src.personen.Regisur;
import src.personen.Schauspieler;

import java.util.ArrayList;

public class Filme {
    private String titel;
    private String beschreibung;
    private String ErscheinungsDat; //TODO IN EIN RICHTIGES FORMATwandlen
    private int id;

    private ArrayList<Schauspieler> schauspieler;
    private Regisur regisur;
    private src.filme.IMDbBewertungen imdbBewertungen;





    public Filme(String titel, String beschreibung, String erscheinungsDat, int id,  IMDbBewertungen imdbBewertungen) {
        this.titel = titel;
        this.beschreibung = beschreibung;
        ErscheinungsDat = erscheinungsDat;
        this.id = id;
        this.regisur = regisur;
        this.imdbBewertungen = imdbBewertungen;
    }

    public Filme(String titel, String beschreibung, String erscheinungsDat, int id) {
        this.titel = titel;
        this.beschreibung = beschreibung;
        ErscheinungsDat = erscheinungsDat;
        this.id = id;
        this.regisur = regisur;
        this.imdbBewertungen = imdbBewertungen;
    }
//TODO DOPPELTE RAUS
    public void addBezihungSchauspieler(Schauspieler s1){
        schauspieler.add(s1);
    };


    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getErscheinungsDat() {
        return ErscheinungsDat;
    }

    public void setErscheinungsDat(String erscheinungsDat) {
        ErscheinungsDat = erscheinungsDat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Schauspieler> getSchauspielers() {
        return schauspieler;
    }

    public void setSchauspielers(ArrayList<Schauspieler> schauspielers) {
        this.schauspieler = schauspielers;
    }

    public Regisur getRegisur() {
        return regisur;
    }

    public void setRegisur(Regisur regisur) {
        this.regisur = regisur;
    }

    public src.filme.IMDbBewertungen getImdbBewertungen() {
        return imdbBewertungen;
    }

    public void setImdbBewertungen(src.filme.IMDbBewertungen imdbBewertungen) {
        this.imdbBewertungen = imdbBewertungen;
    }
}

