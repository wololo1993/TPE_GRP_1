package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

/**
 * Only the method getCrypter to get the right Crypter
 *
 * @Author TPE_GRP_1
 */
public class CrypterFactory {
    /**
     * gibt ein Crypter mit zugefuegtem Key zurück
     * needs the name of the wanted crypter as a String
     *
     * @param crypter String name of wanted Crypter
     * @param key     Key
     * @return Crypter Interface
     */
    public static Crypter getCrypter(String crypter, Key key) {
        Crypter retcrypter = null;
        try {
            if (!crypter.equals("XOR") && !crypter.equals("SUB") && !crypter.equals("CAESAR")) {
                throw new CrypterException("Wrong Crypter name there is \"XOR\",\"SUB\",\"CAESAR\"");
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
            e.printStackTrace();
        }
        return retcrypter;
    }
}
