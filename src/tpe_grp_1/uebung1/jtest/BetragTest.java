package tpe_grp_1.uebung1.jtest;

import tpe_grp_1.uebung1.main.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class BetragTest {


    @Test
    public void testGetBetrag() {
        Betrag betrag = new Betrag(201.23, Waehrungen.dollar);
        long erg = betrag.getBetrag();
        assertEquals(20123, erg);

    }

    @Test
    public void testGetWaehrung() {
        Betrag betrag = new Betrag(201, Waehrungen.yen);
        assertEquals(true, betrag.getWaehrung().equals(Waehrungen.yen));
    }

    @Test
    public void testGetVorkomma() {
        Betrag betrag = new Betrag(-201.0, Waehrungen.yen);
        assertEquals(201, betrag.getVorkomma());
    }

    /**
     * test 0
     */
    @Test
    public void testGetNachkomma() {
        Betrag betrag = new Betrag(-201., Waehrungen.yen);
        assertEquals(0, betrag.getNachkomma());
    }

    @Test
    public void testGetNachkomma2() {
        Betrag betrag = new Betrag(-201.3847, Waehrungen.yen);
        assertEquals(38, betrag.getNachkomma());
    }

    @Test
    public void testToString() {
        Betrag betrag = new Betrag(-201.3847, Waehrungen.yen);
    }

    @Test
    public void testGetAsDouble() {
        Betrag betrag = new Betrag(-201.83, Waehrungen.yen);
        assertEquals(-201.83, betrag.getAsDouble(), 0.01);
    }

    @Test
    public void testGetAsDouble2() {
        Betrag betrag = new Betrag(201.83, Waehrungen.yen);
        assertEquals(201.83, betrag.getAsDouble(), 0.01);
    }

    @Test
    public void testGetVorzeichen() {
        Betrag betrag = new Betrag(-201.0, Waehrungen.yen);
        assertEquals(-1, betrag.getVorzeichen());
    }

    @Test
    public void testGetVorzeichen2() {
        Betrag betrag = new Betrag(0.0, Waehrungen.yen);
        assertEquals(1, betrag.getVorzeichen());
    }
}