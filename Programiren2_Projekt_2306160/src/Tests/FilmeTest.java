package Tests;

import filme.Filme;
import org.junit.jupiter.api.Test;
import personen.Schauspieler;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class FilmeTest {

    @Test
    void testFilmeConstructor() {
        Filme filme = new Filme("Test Titel", "Test Beschreibung", "2023-01-01", 1);
        assertEquals("Test Titel", filme.getTitel());
        assertEquals("Test Beschreibung", filme.getBeschreibung());
        assertEquals("2023-01-01", filme.getErscheinungsDat());
        assertEquals(1, filme.getId());
    }

    @Test
    void testAddBezihungSchauspieler() {
        Filme filme = new Filme("Test Titel", "Test Beschreibung", "2023-01-01", 1);
        Schauspieler schauspieler = new Schauspieler("John Doe", 1);
        filme.addBezihungSchauspieler(schauspieler);

        assertEquals(1, filme.getSchauspielers().size());
        assertEquals(schauspieler, filme.getSchauspielers().get(0));
    }
}
