package src;

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



}
