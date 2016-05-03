
package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

/**
 * Only the method getCrypter to get the right Crypter
 *
 * @Author TPE_GRP_1
 */
public class CrypterFactory {

    private static String STRINGOFENUMS = fillStringOfEnum();

    /**
     * gibt ein Crypter mit zugefuegtem Key zurueck
     * needs the name of the wanted crypter as a String
     *
     * @param crypter String name of wanted Crypter
     * @param key     Key
     * @return Crypter Interface
     */
    public static Crypter getCrypter(String crypter, Key key) {  // gibt interface zurück
        Crypter retcrypter = null;
        try {
            if (isNotInEnum(crypter)) { // falls ja gleich abgefangen
                throw new CrypterException("Wrong Crypter name there is :" + crypter + ": should be " + STRINGOFENUMS);
            }
            switch (CrypterEnum.valueOf(crypter)) {
                case XOR:
                    retcrypter = new CrypterXOR(key);
                    break;
                case SUB:
                    retcrypter = new CrypterSubstitution(key);
                    break;
                case CAESAR:
                    retcrypter = new CrypterCaesar(key);
                    break;
                default:
                    break;
            }
        } catch (CrypterException e) {
            e.printStackTrace(); // hier abgefangen 
        }
        return retcrypter;
    }


    /**
     * fills the "STRINGOFENUMS"
     *
     * @return String
     */

    private static boolean isNotInEnum(String crypter) {
        boolean isNotInEnum = true;
        String[] ary = STRINGOFENUMS.split(":"); // splitet an : und gibt enums zurück
        for (String s : ary) {
            if (crypter.equals(s)) {
                isNotInEnum = false;
            }
        }
        return isNotInEnum;
    }

    /**
     * Fills the
     *
     * @return
     */
    private static String fillStringOfEnum() {
        String s = ":"; // string erstellen
        for (CrypterEnum e : CrypterEnum.values()) { // macht aus namen der enums string
            s = s + e.name() + ":";
        }
        return s;
    }
}
