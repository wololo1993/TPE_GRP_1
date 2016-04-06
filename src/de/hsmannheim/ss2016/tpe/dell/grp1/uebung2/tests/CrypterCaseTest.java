package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.tests;

import org.junit.Test;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter.Crypter;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter.CrypterFactory;

import static org.junit.Assert.assertTrue;

/**
 * @Author TPE_GRP_1
 */
public class CrypterCaseTest {

    /**
     * geht jeden char in reihenfolge mit Crypter.verschluesseln durch
     * und gibt das Ergebnis als String zurück
     * @param string String
     * @param crypter Crypter
     * @return String
     */
    private String verschluesselString(String string, Crypter crypter){
        String erg = "";

        for(int i = 0; i<string.length();i++){
            try {
                erg = erg +crypter.verschluesseln(string.charAt(i))+"";
            } catch (CrypterException e) {
                e.printStackTrace();
            }
        }

        return erg;
    }

    /**
     * geht jeden char in reihenfolge mit Crypter.entschlüsseln durch
     * und gibt das Ergebnis als String zurück
     * @param string String
     * @param crypter Crypter
     * @return String
     */
    private String entschluessleString(String string, Crypter crypter){
        String erg = "";

        for(int i = 0; i<string.length();i++){
            try {
                erg = erg +crypter.entschluesseln(string.charAt(i))+"";
            } catch (CrypterException e) {
                e.printStackTrace();
            }
        }

        return erg;
    }



    @Test
    public void testReset() throws Exception {

    }


    @Test
    public void testVerschluesselnCaesar() throws Exception {

        Key<String> key= new Key("C");
        Crypter c = CrypterFactory.getCrypter("CAESAR",key);
        String string="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String erg = verschluesselString(string,c);
        String expected = "DEFGHIJKLMNOPQRSTUVWXYZABC";

        assertTrue(erg.equals(expected));
    }

    @Test
    public void testVerschluesselnCaesar2() throws Exception {

    }

    @Test
    public void testEntschluesselnCaesar() throws Exception {
        Key<String> key= new Key("C");
        Crypter c = CrypterFactory.getCrypter("CAESAR",key);
        String string = "DEFGHIJKLMNOPQRSTUVWXYZABC";
        String erg = entschluessleString(string,c);
        String expected="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        assertTrue(erg.equals(expected));

    }

    @Test
    public void testVerschluesselnSUB() throws Exception {

        Key<String> key= new Key("UFLPWDRASJMCONQYBVTEXHZKGI");
        Crypter c = CrypterFactory.getCrypter("SUB",key);
        String string="WIKIPEDIAISTINFORMATIV";
        String erg = verschluesselString(string,c);
        String expected = "ZSMSYWPSUSTESNDQVOUESH";
        assertTrue(erg.equals(expected));


    }

    @Test
    public void testEntschluesselnSub() throws Exception {
        Key<String> key= new Key("UFLPWDRASJMCONQYBVTEXHZKGI");
        Crypter c = CrypterFactory.getCrypter("SUB",key);
        String string = "ZSMSYWPSUSTESNDQVOUESH";
        String erg = entschluessleString(string,c);
        String expected="WIKIPEDIAISTINFORMATIV";

        assertTrue(erg.equals(expected));

    }

    @Test
    public void testVerschluesselnXOR() throws Exception {
        Key<String> key= new Key("TPERULES");
        Crypter c = CrypterFactory.getCrypter("XOR",key);
        String string="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String erg = verschluesselString(string,c);
        String expected = "URFVPJB[]ZN^XBJCEBVF@ZRKMJ";
        assertTrue(erg.equals(expected));
    }
    @Test
    public void testEntschluesselnXOR() throws Exception {
        Key<String> key= new Key("TPERULES");
        Crypter c = CrypterFactory.getCrypter("XOR",key);
        String string="URFVPJB[]ZN^XBJCEBVF@ZRKMJ";
        String erg = entschluessleString(string,c);
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        assertTrue(erg.equals(expected));
    }

    @Test
    public void testAufgabeF() throws  Exception{


        Crypter c;
        Crypter d;
        Crypter f;
        String geheimeBotschaft = "SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_";
        Key keySub = new Key("MNBVCXYLKJHGFDSAPOIUZTREWQ");
        Key keyCaesar = new Key("V");
        Key keyXOR = new Key("EINSCHLUESSEL");

        //XOR
        c = CrypterFactory.getCrypter("XOR",keyXOR);
        geheimeBotschaft = entschluessleString(geheimeBotschaft,c);

        System.out.println(geheimeBotschaft);

        //Caesar
        d = CrypterFactory.getCrypter("CAESAR",keyCaesar);
        geheimeBotschaft = entschluessleString(geheimeBotschaft,d);

        System.out.println(geheimeBotschaft);

        //SUB
        f = CrypterFactory.getCrypter("SUB",keySub);
        geheimeBotschaft = entschluessleString(geheimeBotschaft,f);

        System.out.println(geheimeBotschaft);



    }





}