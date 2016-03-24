package tpe_grp_1.aufgabe1.jtest;

import org.junit.Test;
import tpe_grp_1.aufgabe1.main.*;

import static org.junit.Assert.*;

public class KontoTest {

    Konto konto = new Konto(Waehrungen.dollar,"Jan Spliethoff");
    @Test
    public void testGetInhaber1() throws Exception {
        assertEquals("Jan Spliethoff",konto.getInhaber());
    }

    @Test
    public void testGetInhaber2() throws Exception {
        assertFalse("Jan ethoff".equalsIgnoreCase(konto.getInhaber()));
    }


    @Test
    public void testGetWaehrung() throws Exception {
        assertTrue(konto.getWaehrung().equals(Waehrungen.dollar));
    }

    @Test
    public void testBuche() throws Exception {
        Konto konto = new Konto(Waehrungen.dollar,"Jan Spliethoff");
        konto.buche(new Betrag(200,konto.getWaehrung()));
        assertEquals(200,konto.saldo(),0.001);

    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testGebuehren() throws Exception {
        Konto konto = new Konto(Waehrungen.dollar,"Jan Spliethoff");
        konto.buche(new Betrag(100.0,konto.getWaehrung()));
        konto.gebuehren(100);
        assertEquals(90.0,konto.saldo(),0.001);
    }


    @Test
    public void testSaldo() throws Exception {
        Konto konto = new Konto(Waehrungen.dollar,"Jan Spliethoff");
        assertEquals(0.0,konto.saldo(),0.001);
    }

    //Missing vorzeichen in betrag
    @Test
    public void testSaldo2() throws Exception {
        Konto konto = new Konto(Waehrungen.dollar,"Jan Spliethoff");
        konto.buche(new Betrag(-200,konto.getWaehrung()));
        assertEquals(-200.0,konto.saldo(),0.001);
    }
}