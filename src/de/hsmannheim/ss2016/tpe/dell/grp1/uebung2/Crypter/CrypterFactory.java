package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

public class CrypterFactory {
    /**
     * gibt ein Crypter zurück
     * @param crypter
     * @param key
     * @return
     */
    public static Crypter getCrypter(String crypter,Key key){
        CrypterCase crypterC = CrypterEnum.valueOf(crypter).getCrypter();
        crypterC.setKey(key);
        crypterC.reset();

        return crypterC;
    }
}
