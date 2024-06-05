package src.filme;

public class IMDbBewertungen {
    private int bewertung;
    private int anzahlBewertungen;

    public IMDbBewertungen(int bewertung, int anzahlBewertungen) {
        this.bewertung = bewertung;
        this.anzahlBewertungen = anzahlBewertungen;
    }

    public int getBewertung() {
        return bewertung;
    }

    public void setBewertung(int bewertung) {
        this.bewertung = bewertung;
    }

    public int getAnzahlBewertungen() {
        return anzahlBewertungen;
    }

    public void setAnzahlBewertungen(int anzahlBewertungen) {
        this.anzahlBewertungen = anzahlBewertungen;
    }
}
