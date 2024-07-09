package Tests;

import filme.Filme;
import org.junit.jupiter.api.Test;
import personen.Schauspieler;
import helper.Datahelper;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

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



    }

    @Test
    void testFindSchauspilernetzwerk() {

    }


}
