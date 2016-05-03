package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.tests;

import org.junit.Test;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Crypter.Crypter;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Crypter.CrypterFactory;

import static org.junit.Assert.*;

/**
 * @Author TPE_GRP_1
 */
public class CrypterCaseTest {
    /**
     * geht jeden char in reihenfolge mit Crypter.verschluesseln durch
     * und gibt das Ergebnis als String zurück
     *
     * @param string  String
     * @param crypter Crypter
     * @return String
     */
    private String verschluesselString(String string, Crypter crypter) {  // nur auf interface von crypter zugreifbar
        String erg = "";


        for (int i = 0; i < string.length(); i++) { // geht für jeden character durch
            try {
                erg = erg + crypter.verschluesseln(string.charAt(i)) + "";
            } catch (CrypterException e) {
                e.printStackTrace();
            }
        }
        return erg;
    }

    /**
     * geht jeden char in reihenfolge mit Crypter.entschlüsseln durch
     * und gibt das Ergebnis als String zurück
     *
     * @param string  String
     * @param crypter Crypter
     * @return String
     */
    private String entschluessleString(String string, Crypter crypter) {
        String erg = "";

        for (int i = 0; i < string.length(); i++) {
            try {
                erg = erg + crypter.entschluesseln(string.charAt(i)) + ""; // try catch wegen exception
            } catch (CrypterException e) {
                e.printStackTrace();
            }
        }
        return erg;
    }


    @Test
    public void testKombiOfAll(){
        Key<String> keySUB =  new Key<>("QWEDSAVXYCFRTGZHBNJUIKMLOP");
        Key<String> keyXOR =  new Key<>("UHSDSJK");
        Key<String> keyCAESAR =  new Key<>("U");

        Crypter sub = CrypterFactory.getCrypter("SUB",keySUB);
        Crypter xor = CrypterFactory.getCrypter("XOR",keyXOR);
        Crypter caesar = CrypterFactory.getCrypter("CAESAR",keyCAESAR);

        String s = "MEssAgeZA";

        assertEquals(s.toUpperCase(),entschluessleString(verschluesselString(s,sub),sub));
        assertEquals(s.toUpperCase(),entschluessleString(verschluesselString(s,caesar),caesar));
        String ergxor = verschluesselString(s,xor);
        xor.reset(); // da position gespeichert ist 
        assertEquals(s.toUpperCase(),entschluessleString(ergxor,xor));
    }

    @Test
    public void testVerschluesselnCaesar() {

        Key<String> key = new Key<>("C");
        Crypter c = CrypterFactory.getCrypter("CAESAR", key);
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String erg = verschluesselString(string, c);
        String expected = "DEFGHIJKLMNOPQRSTUVWXYZABC";

        assertEquals(expected, erg);
    }

    @Test
    public void testEntschluesselnCaesar() {
        Key<String> key = new Key<>("C");
        Crypter c = CrypterFactory.getCrypter("CAESAR", key);
        String string = "DEFGHIJKLMNOPQRSTUVWXYZABC";
        String erg = entschluessleString(string, c);
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        assertEquals(expected, erg);

    }

    @Test
    public void testVerschluesselnSUB() {

        Key<String> key = new Key<>("UFLPWDRASJMCONQYBVTEXHZKGI");
        Crypter c = CrypterFactory.getCrypter("SUB", key);
        String string = "WIKIPEDIAISTINFORMATIV";
        String erg = verschluesselString(string, c);
        String expected = "ZSMSYWPSUSTESNDQVOUESH";
        assertTrue(erg.equals(expected));


    }

    @Test
    public void testEntschluesselnSub() {
        Key<String> key = new Key<>("UFLPWDRASJMCONQYBVTEXHZKGI");
        Crypter c = CrypterFactory.getCrypter("SUB", key);
        String string = "ZSMSYWPSUSTESNDQVOUESH";
        String erg = entschluessleString(string, c);
        String expected = "WIKIPEDIAISTINFORMATIV";

        assertTrue(erg.equals(expected));

    }

    @Test
    public void testVerschluesselnXOR() {
        Key<String> key = new Key<>("TPERULES");
        Crypter c = CrypterFactory.getCrypter("XOR", key);


        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String erg = verschluesselString(string, c);
        String expected = "URFVPJB[]ZN^XBJCEBVF@ZRKMJ";
        assertTrue(erg.equals(expected));
    }

    @Test
    public void testEntschluesselnXOR() {
        Key<String> key = new Key<>("TPERULES");
        Crypter c = CrypterFactory.getCrypter("XOR", key);
        String string = "URFVPJB[]ZN^XBJCEBVF@ZRKMJ";
        String erg = entschluessleString(string, c);
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        assertTrue(erg.equals(expected));
    }

    @Test
    public void testAufgabeF() {


        Crypter c;
        Crypter d;
        Crypter f;
        String geheimeBotschaft = "SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_";
        Key<String> keySub = new Key<>("MNBVCXYLKJHGFDSAPOIUZTREWQ");
        Key<String> keyCaesar = new Key<>("V");
        Key<String> keyXOR = new Key<>("EINSCHLUESSEL");

        //XOR
        c = CrypterFactory.getCrypter("XOR", keyXOR);
        geheimeBotschaft = entschluessleString(geheimeBotschaft, c);

        //Caesar
        d = CrypterFactory.getCrypter("CAESAR", keyCaesar);
        geheimeBotschaft = entschluessleString(geheimeBotschaft, d);

        //SUB
        f = CrypterFactory.getCrypter("SUB", keySub);
        geheimeBotschaft = entschluessleString(geheimeBotschaft, f);

        assertEquals("UNDXWIEDERXEINXBLATTXERLEDIGT", geheimeBotschaft);


    }


    /**
     * tests if XOR resets Position
     * and that ENUM returns a new Crypter each time
     *
     * @throws Exception
     */
    @Test
    public void resetTest() {
        Key<String> key = new Key<>("SADIUH");
        Crypter c = CrypterFactory.getCrypter("XOR", key);

        String verschluesselt = verschluesselString("HALLO", c);
        String entschluesselt = entschluessleString(verschluesselt, c);

        assertFalse("Hallo".equals(entschluesselt));

        c.reset();

        Crypter b = CrypterFactory.getCrypter("XOR", new Key<>("UNDJJL"));

        entschluesselt = entschluessleString(verschluesselt, c);

        assertEquals("Hallo".toUpperCase(), entschluesselt);

    }
}