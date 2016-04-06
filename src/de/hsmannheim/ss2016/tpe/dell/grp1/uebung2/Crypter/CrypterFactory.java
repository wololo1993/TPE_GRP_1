package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;
/**
 * @Author TPE_GRP_1
 */
public class CrypterFactory {
    /**
     * gibt ein Crypter zurück
     * @param crypter String
     * @param key Key
     * @return Crypter Interface
     */
    public static Crypter getCrypter(String crypter,Key key){
        CrypterCase crypterC = CrypterEnum.valueOf(crypter).getCrypter();
        crypterC.setKey(key);
        crypterC.reset();

        return crypterC;
    }
}
