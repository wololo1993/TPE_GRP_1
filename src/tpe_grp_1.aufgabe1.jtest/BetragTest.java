package tpe_grp_1.aufgabe1.jtest;

import tpe_grp_1.aufgabe1.main.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class BetragTest {

    @Test
    public void testGetBetrag() throws Exception {
        Betrag betrag = new Betrag(201.23,Waehrungen.dollar);
        long erg = betrag.getBetrag();
        assertEquals(20123,erg);
    }

    @Test
    public void testGetWaehrung() throws Exception {
        Betrag betrag = new Betrag(201,Waehrungen.yen);
        assertEquals(true, betrag.getWaehrung().equals(Waehrungen.yen));
    }

    @Test
    public void testAddiere() throws Exception {
        Betrag betrag = new Betrag(200.93,Waehrungen.dollar);
        Betrag betrag2 = new Betrag(10,Waehrungen.dollar);
        long erg = betrag.addiere(betrag2);
        assertEquals(erg,21093);
    }

    @Test
    public void testSubtrahiere() throws Exception {

    }

    @Test
    public void testMultipliziere() throws Exception {

    }

    @Test
    public void testMultipliziere1() throws Exception {

    }

    @Test
    public void testProzent() throws Exception {

    }

    @Test
    public void testPromille() throws Exception {

    }

    @Test
    public void testGetVorkomma() throws Exception {
        Betrag betrag = new Betrag(-201.0,Waehrungen.yen);
        assertEquals(201,betrag.getVorkomma());
    }

    @Test
    public void testGetNachkomma() throws Exception {
        Betrag betrag = new Betrag(-201.3847,Waehrungen.yen);
        assertEquals(38,betrag.getNachkomma());
        //wieso gibt es da -38 zurück ?
    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testGetAsDouble() throws Exception {
        Betrag betrag = new Betrag(-201.83,Waehrungen.yen);
        assertEquals(-201.83,betrag.getAsDouble(),0.01);
    }

    @Test
    public void testGetAsDouble2() throws Exception {
        Betrag betrag = new Betrag(201.83,Waehrungen.yen);
        assertEquals(201.83,betrag.getAsDouble(),0.01);
    }

    @Test
    public void testGetVorzeichen() throws Exception {
        Betrag betrag = new Betrag(-201.0,Waehrungen.yen);
        assertEquals(-1,betrag.getVorzeichen());
    }
    @Test
    public void testGetVorzeichen2() throws Exception {
        Betrag betrag = new Betrag(0.0,Waehrungen.yen);
        assertEquals(1,betrag.getVorzeichen());
        //hier fehlt noch dass 0 positiv is
    }
}