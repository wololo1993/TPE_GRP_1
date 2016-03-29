package tpe_grp_1.uebung1.jtest;

import org.junit.Test;
import tpe_grp_1.uebung1.main.*;

import static org.junit.Assert.*;

public class WaehrungTest {

    private Waehrung waehrung = new Waehrung("Bobo", "bob", 1.3817);

    @Test
    public void testGetName() {
        assertTrue("Bobo".equalsIgnoreCase(waehrung.getName()));
    }

    @Test
    public void testGetKuerzel() {
        assertTrue("bob".equalsIgnoreCase(waehrung.getKuerzel()));
    }

    @Test
    public void testGetKurs() {
        assertEquals(1.3817, waehrung.getKurs(), 0.001);
    }


    @Test
    public void testUmrechnen() {
        Waehrung waehrung = new Waehrung("Bobo", "bob", 1.0);
        Waehrung waehrung2 = new Waehrung("bibi", "bib", 1.5);
        long test = waehrung2.umrechnen(200, waehrung);
        assertEquals(300, test);
    }

    @Test
    public void testToString() {
        Waehrung waehrung = new Waehrung("Bobo", "bob", 1.0);
        String expected = "Bobo [bob] 1$ = 1.0 bob";
        assertTrue(expected.equals(waehrung.toString()));
    }


    @Test
    public void testEquals() {
        Waehrung waehrung = new Waehrung("Diebel", "DD", 99.23);
        Waehrung waehrung2 = new Waehrung("Diebel", "DD", 99.23);
        assertTrue(waehrung.equals(waehrung2));
    }

    /**
     * not equals amount
     */
    @Test
    public void testEquals2() {
        Waehrung waehrung = new Waehrung("Diebel", "DD", 99.23);
        Waehrung waehrung2 = new Waehrung("Diebel", "DD", 99.33);
        assertFalse(waehrung.equals(waehrung2));
    }

    /**
     * not equals kuerzel
     */
    @Test
    public void testEquals3() {
        Waehrung waehrung = new Waehrung("Diebel", "DD", 99.23);
        Waehrung waehrung2 = new Waehrung("Diebel", "dD", 99.23);
        assertFalse(waehrung.equals(waehrung2));
    }


}