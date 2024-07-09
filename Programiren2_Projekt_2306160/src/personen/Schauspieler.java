package personen;

import filme.Filme;

import java.util.ArrayList;

public class Schauspieler extends Person {

    private ArrayList<Filme> filme;

    public Schauspieler(String name, int id) {
        super(name, id);
        filme = new ArrayList<>();

    }

    public ArrayList<Filme> getFilme() {
        return filme;
    }

    public void setFilme(ArrayList<Filme> filme) {
        this.filme = filme;
    }

    public void addfilm(Filme f){
        filme.add(f);
    }
}
