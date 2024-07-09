package Tests;

import filme.Filme;
import org.junit.jupiter.api.Test;
import personen.Schauspieler;
import helper.Datahelper;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class DatahelperTest {

    @Test
    void testAddIfNotDuplicate() {
        ArrayList<Schauspieler> schauspielerList = new ArrayList<>();
        Schauspieler schauspieler1 = new Schauspieler("John Doe", 1);
        Schauspieler schauspieler2 = new Schauspieler("Jane Doe", 2);
        Schauspieler duplicateSchauspieler = new Schauspieler("John Doe", 1);

        Datahelper.addIfNotDuplicate(schauspielerList, schauspieler1, Schauspieler::getId);
        Datahelper.addIfNotDuplicate(schauspielerList, schauspieler2, Schauspieler::getId);
        Datahelper.addIfNotDuplicate(schauspielerList, duplicateSchauspieler, Schauspieler::getId);

        assertEquals(2, schauspielerList.size());
        assertTrue(schauspielerList.contains(schauspieler1));
        assertTrue(schauspielerList.contains(schauspieler2));
        assertFalse(schauspielerList.contains(duplicateSchauspieler));
    }

    @Test
    void testFindByID() {
        ArrayList<Schauspieler> schauspielerList = new ArrayList<>();
        Schauspieler schauspieler1 = new Schauspieler("John Doe", 1);
        Schauspieler schauspieler2 = new Schauspieler("Jane Doe", 2);
        schauspielerList.add(schauspieler1);
        schauspielerList.add(schauspieler2);

        Schauspieler foundSchauspieler = Datahelper.findByID( 1,schauspielerList, Schauspieler::getId);
        Schauspieler notFoundSchauspieler = Datahelper.findByID(3,schauspielerList,  Schauspieler::getId);

        assertNotNull(foundSchauspieler);
        assertEquals(schauspieler1, foundSchauspieler);
        assertNull(notFoundSchauspieler);
    }

    @Test
    void testFindByString() {
        ArrayList<Schauspieler> schauspielerList = new ArrayList<>();
        Schauspieler schauspieler1 = new Schauspieler("John Doe", 1);
        Schauspieler schauspieler2 = new Schauspieler("Jane Doe", 2);
        schauspielerList.add(schauspieler1);
        schauspielerList.add(schauspieler2);

        ArrayList<Schauspieler> foundSchauspieler = Datahelper.findByString("John Doe", schauspielerList, Schauspieler::getName);
        ArrayList<Schauspieler> notFoundSchauspieler = Datahelper.findByString("Alice",schauspielerList,  Schauspieler::getName);

        assertEquals(1, foundSchauspieler.size());
        assertEquals(schauspieler1, foundSchauspieler.getFirst());
        assertEquals(0,notFoundSchauspieler.size());
    }

    @Test
    void testFindnetzwerk() {
        // Listen in die das netzwerk eingetragen wird
        ArrayList<Filme> filmeArrayList = new ArrayList<>();
        ArrayList<Schauspieler> schauspielerArrayList = new ArrayList<>() ;

        // Netztwerk aufvbauen
        Filme film1 = new Filme("F1","TESTING","TEST",11);
        Filme film2 = new Filme("F2","TESTING","TEST",12);

        Schauspieler spieler1 = new Schauspieler("John Doe",1);
        Schauspieler spieler2 = new Schauspieler("John Doe",2);
        Schauspieler spieler3 = new Schauspieler("John Doe",3);

        spieler1.addfilm(film1);
        spieler1.addfilm(film2);
        spieler2.addfilm(film1);
        spieler3.addfilm(film2);

        film1.addBezihungSchauspieler(spieler1);
        film2.addBezihungSchauspieler(spieler1);
        film1.addBezihungSchauspieler(spieler2);
        film2.addBezihungSchauspieler(spieler3);

        Datahelper.findnetzwerk(film1,filmeArrayList,schauspielerArrayList);

        assertEquals(2,filmeArrayList.size());
        assertEquals(2,schauspielerArrayList.size());


    }

    @Test
    void testFindSchauspilernetzwerk() {
        // Listen in die das netzwerk eingetragen wird
        ArrayList<Filme> filmeArrayList = new ArrayList<>();
        ArrayList<Schauspieler> schauspielerArrayList = new ArrayList<>() ;

        // Netztwerk aufvbauen
        Filme film1 = new Filme("F1","TESTING","TEST",11);
        Filme film2 = new Filme("F2","TESTING","TEST",12);
        Filme film3 = new Filme("F2","TESTING","TEST",13);

        Schauspieler spieler1 = new Schauspieler("John Doe",1);
        Schauspieler spieler2 = new Schauspieler("John Doe",2);
        Schauspieler spieler3 = new Schauspieler("John Doe",3);
        Schauspieler spieler4 = new Schauspieler("John Doe",3);



        spieler1.addfilm(film1);
        spieler1.addfilm(film2);
        spieler2.addfilm(film1);
        spieler3.addfilm(film2);
        spieler3.addfilm(film3);


        film1.addBezihungSchauspieler(spieler1);
        film2.addBezihungSchauspieler(spieler1);
        film1.addBezihungSchauspieler(spieler2);
        film2.addBezihungSchauspieler(spieler3);
        film3.addBezihungSchauspieler(spieler3);
        film3.addBezihungSchauspieler(spieler4);

        Datahelper.findSchauspilernetzwerk(spieler1,schauspielerArrayList,filmeArrayList);

        assertEquals(2,filmeArrayList.size());
        assertEquals(3,schauspielerArrayList.size());




    }


}
