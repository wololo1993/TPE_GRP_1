package tpe_grp_1.aufgabe1.jtest;

import tpe_grp_1.aufgabe1.main.*;

import static org.junit.Assert.*;

public class BetragTest {

    @org.junit.Test
    public void testGetBetrag() throws Exception {
        Betrag betrag = new Betrag(201,Waehrungen.dollar);
        long erg = betrag.getBetrag();
        assertEquals(erg,201);
    }

    @org.junit.Test
    public void testGetWaehrung() throws Exception {
        Betrag betrag = new Betrag(201,Waehrungen.yen);
        assertEquals(true, betrag.getWaehrung().equals(Waehrungen.yen));
    }

    @org.junit.Test
    public void testAddiere() throws Exception {

    }

    @org.junit.Test
    public void testSubtrahiere() throws Exception {

    }

    @org.junit.Test
    public void testMultipliziere() throws Exception {

    }

    @org.junit.Test
    public void testMultipliziere1() throws Exception {

    }

    @org.junit.Test
    public void testProzent() throws Exception {

    }

    @org.junit.Test
    public void testPromille() throws Exception {

    }

    @org.junit.Test
    public void testGetVorkomma() throws Exception {

    }

    @org.junit.Test
    public void testGetNachkomma() throws Exception {

    }

    @org.junit.Test
    public void testToString() throws Exception {

    }

    @org.junit.Test
    public void testGetAsDouble() throws Exception {

    }

    @org.junit.Test
    public void testGetVorzeichen() throws Exception {

    }
}