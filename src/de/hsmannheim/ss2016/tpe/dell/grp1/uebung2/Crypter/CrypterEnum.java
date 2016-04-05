package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Crypter;

/**
 * Enum of all Crypters
 */
public enum CrypterEnum {
    CAESAR(new CrypterCaesar()),SUB(new CrypterSubstitution()),XOR(new CrypterXOR());

    private CrypterCase crypter;

    private CrypterEnum(CrypterCase crypter){
        this.crypter = crypter;
    }

    protected CrypterCase getCrypter() {
        return crypter;
    }
}
