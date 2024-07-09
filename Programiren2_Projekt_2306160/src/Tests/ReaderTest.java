package Tests;

import filme.Filme;
import helper.Reader;
import org.junit.jupiter.api.Test;
import personen.Regisur;
import personen.Schauspieler;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class ReaderTest {

    @Test
    void testRead() {
        Reader reader = new Reader();
        ArrayList<Filme> filme = new ArrayList<>();
        ArrayList<Regisur> regisure = new ArrayList<>();
        ArrayList<Schauspieler> schauspieler = new ArrayList<>();

        int result = reader.read("testfile.txt", filme, regisure, schauspieler);
        assertEquals(0, result);
    }

    /*
    @Test
    void testHandleLine() {
        Reader reader = new Reader();
        ArrayList<Schauspieler> schauspieler = new ArrayList<>();
        ArrayList<Filme> filme = new ArrayList<>();
        ArrayList<Regisur> regisur = new ArrayList<>();

        // Test the handleLine method by calling it directly
        reader.handleLine("New_Entity", schauspieler, filme, regisur);
        // Add assertions to verify the expected behavior
    }
    */

}
