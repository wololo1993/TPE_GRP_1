package tpe_grp_1.uebung1.jtest;

import org.junit.Before;
import org.junit.Test;
import tpe_grp_1.uebung1.main.*;

import static org.junit.Assert.*;

public class KontoTest {

    private Konto konto = new Konto(Waehrungen.dollar, "Gunther Gaus");

    @Before
    public void setUp() {
        konto = new Konto(Waehrungen.dollar, "Gunther Gaus");

    }


    @Test
    public void testGetInhaber1() {
        assertEquals("Gunther Gaus", konto.getInhaber());
    }

    /**
     * not equals
     */
    @Test
    public void testGetInhaber2() {
        assertFalse("Gunther baus".equalsIgnoreCase(konto.getInhaber()));
    }


    @Test
    public void testGetWaehrung() {
        assertTrue(konto.getWaehrung().equals(Waehrungen.dollar));
    }

    @Test
    public void testBuche() {
        konto.buche(new Betrag(200, konto.getWaehrung()));
        assertEquals(200, konto.saldo(), 0.001);

    }

    /**
     * Test negative
     */
    @Test
    public void testBuche2() {
        konto.buche(new Betrag(-200, konto.getWaehrung()));
        assertEquals(-200, konto.saldo(), 0.001);

    }


    /**
     * Test exchange rate
     */
    @Test
    public void testBuche3() {
        Konto konto = new Konto(Waehrungen.euro, "Exchangerate Test");
        konto.buche(new Betrag(2000, Waehrungen.yen));

        assertEquals(14.34, konto.saldo(), 0.01);
    }

    /**
     * Tests 0
     */
    @Test
    public void testBuche4() {
        konto.buche(new Betrag(0, konto.getWaehrung()));
        assertEquals(0, konto.saldo(), 0.001);

    }


    @Test
    public void testToString() {
        konto.buche(new Betrag(200.2, konto.getWaehrung()));
        konto.buche(new Betrag(-10, konto.getWaehrung()));
        konto.buche(new Betrag(20, konto.getWaehrung()));
        String expected = "Kontoinhaber: Gunther Gaus\n"+
                "Währung: "+"Dollar\n"+
                "-----------------\n"+
                "200,20 $\n"+
                "-10,0 $\n"+
                "20,0 $\n"+
                "-----------------\n"+
                "Saldo: "+"210,20 $";
        assertEquals(expected,konto.toString());
    }

    /**
     * Teste negative Werte
     */
    @Test
    public void testToString2() {
        konto.buche(new Betrag(-200.33, konto.getWaehrung()));
        konto.buche(new Betrag(-50, konto.getWaehrung()));
        String expected = "Kontoinhaber: Gunther Gaus\n"+
                "Währung: "+"Dollar\n"+
                "-----------------\n"+
                "-200,33 $\n"+
                "-50,0 $\n"+
                "-----------------\n"+
                "Saldo: "+"-250,33 $";
        assertEquals(expected,konto.toString());
    }

    @Test
    public void testGebuehren() {
        konto.buche(new Betrag(100.0, konto.getWaehrung()));
        konto.gebuehren(0.001);
        assertEquals(90.0, konto.saldo(), 0.001);
    }

    /**
     * Teste negative Werte
     */
    @Test
    public void testGebuehren2() {
        konto.buche(new Betrag(-100.0, konto.getWaehrung()));
        konto.gebuehren(0.001);
        assertEquals(-110.0, konto.saldo(), 0.001);
    }


    @Test
    public void testSaldo() {
        assertEquals(0.0, konto.saldo(), 0.001);
    }

    @Test
    public void testSaldo2() {
        konto.buche(new Betrag(-200, konto.getWaehrung()));
        assertEquals(-200.0, konto.saldo(), 0.001);
    }
}