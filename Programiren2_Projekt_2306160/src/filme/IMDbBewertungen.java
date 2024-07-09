package filme;

public class IMDbBewertungen {
    private double bewertung;
    private int anzahlBewertungen;

    public IMDbBewertungen(double bewertung, int anzahlBewertungen) {
        this.bewertung = bewertung;
        this.anzahlBewertungen = anzahlBewertungen;
    }

    public double getBewertung() {
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
