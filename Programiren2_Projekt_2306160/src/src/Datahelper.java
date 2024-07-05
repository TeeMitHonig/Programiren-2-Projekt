package src;

import src.filme.Filme;
import src.personen.Schauspieler;

import java.util.ArrayList;
import java.util.function.Function;

public class Datahelper {



    static public  <T> T findByID(int id, ArrayList<T> list , Function<T, Integer> getidFunc){
        for(T element : list)
            if (getidFunc.apply(element) == id)
                return element;
        return null;
    }

    static public <T> ArrayList<T> findByString(String serachString, ArrayList<T> searchlist , Function<T, String> getSFunc){
        ArrayList<T>list = new ArrayList<>();
        for(T element : searchlist)
            if(getSFunc.apply(element).contains(serachString))
                list.add(element);
        return list;
    }

    static public <T> void addIfNotDuplicate(ArrayList<T> list, T item, Function<T, Integer> getIdFunc) {
        boolean isDuplicate = false;
        for (T element : list) {
            if (getIdFunc.apply(element).equals(getIdFunc.apply(item))) {
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            list.add(item);
        }
    }

    static public void findnetzwerk(Filme film,ArrayList<Filme> filme , ArrayList<Schauspieler> schauspieler){
        schauspieler.addAll(film.getSchauspielers());
        ArrayList<Filme>temp;
        for(Schauspieler s:schauspieler){
            temp =s.getFilme();
            for(Filme f:temp) {
                addIfNotDuplicate(filme,f,Filme::getId );
            }
        }
    }

    static public void findSchauspilernetzwerk(Schauspieler schauspieler,ArrayList<Schauspieler> schauspielerlist , ArrayList<Filme> filme){
        filme.addAll(schauspieler.getFilme());
        ArrayList<Schauspieler>temp;
        for(Filme f:filme){
            temp =f.getSchauspielers();
            for(Schauspieler s:temp) {
                addIfNotDuplicate(schauspielerlist,s,Schauspieler::getId );
            }
        }
    }

    //Die drüber auch als generic gegen code duplication wird aber nicht verwendet da es sonst zu unleserlich ist

    static public <T,G> void findnettwerk(T normal, ArrayList<T>normalList, ArrayList<G> extra, Function<T, ArrayList<G>> getother, Function<T, Integer> getIdFunc, Function<G, ArrayList<T>> getTs){
        extra.addAll(getother.apply(normal));
        ArrayList<T>temp;
        for(G item : extra){
            temp = getTs.apply(item);
            for(T item2:temp){
                addIfNotDuplicate(normalList,item2,getIdFunc);
            }
        }
    }



}
