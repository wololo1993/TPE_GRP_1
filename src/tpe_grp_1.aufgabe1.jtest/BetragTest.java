package tpe_grp_1.aufgabe1.jtest;

import tpe_grp_1.aufgabe1.main.*;

import static org.junit.Assert.*;

public class BetragTest {

    @org.junit.Test
    public void testGetBetrag() throws Exception {
        Betrag betrag = new Betrag(201.23,Waehrungen.dollar);
        long erg = betrag.getBetrag();
        assertEquals(20123,erg);
    }

    @org.junit.Test
    public void testGetWaehrung() throws Exception {
        Betrag betrag = new Betrag(201,Waehrungen.yen);
        assertEquals(true, betrag.getWaehrung().equals(Waehrungen.yen));
    }

    @org.junit.Test
    public void testAddiere() throws Exception {
        Betrag betrag = new Betrag(200.93,Waehrungen.dollar);
        Betrag betrag2 = new Betrag(10,Waehrungen.dollar);
        long erg = betrag.addiere(betrag2);
        assertEquals(erg,21093);
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
        Betrag betrag = new Betrag(-201.0,Waehrungen.yen);
        assertEquals(201,betrag.getVorkomma());
    }

    @org.junit.Test
    public void testGetNachkomma() throws Exception {
        Betrag betrag = new Betrag(-201.3847,Waehrungen.yen);
        assertEquals(38,betrag.getNachkomma());
        //wieso gibt es da -38 zurück ?
    }

    @org.junit.Test
    public void testToString() throws Exception {

    }

    @org.junit.Test
    public void testGetAsDouble() throws Exception {
        Betrag betrag = new Betrag(-201.83,Waehrungen.yen);
        assertEquals(-201.83,betrag.getAsDouble(),0.01);
    }

    @org.junit.Test
    public void testGetVorzeichen() throws Exception {
        Betrag betrag = new Betrag(-201.0,Waehrungen.yen);
        assertEquals(-1,betrag.getVorzeichen());
    }
    @org.junit.Test
    public void testGetVorzeichen2() throws Exception {
        Betrag betrag = new Betrag(0.0,Waehrungen.yen);
        assertEquals(1,betrag.getVorzeichen());
        //hier fehlt noch dass 0 positiv is
    }
}