package tpe_grp_1.aufgabe1.jtest;

import org.junit.Test;
import tpe_grp_1.aufgabe1.main.*;

import static org.junit.Assert.*;

public class WaehrungTest {
    Waehrung waehrung = new Waehrung("Bobo","bob",1.3817);

    @Test
    public void testGetName() throws Exception {
        assertTrue("Bobo".equalsIgnoreCase(waehrung.getName()));
    }

    @Test
    public void testGetKuerzel() throws Exception {
        assertTrue("bob".equalsIgnoreCase(waehrung.getKuerzel()));
    }

    @Test
    public void testGetKurs() throws Exception {
        assertEquals(1.3817,waehrung.getKurs(),0.001);
    }


    @Test
    public void testUmrechnen() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testHashCode() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {

    }
}