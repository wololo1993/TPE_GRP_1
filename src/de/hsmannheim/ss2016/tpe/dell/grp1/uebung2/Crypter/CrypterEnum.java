package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

/**
 * Enum of all Crypters
 * @Author TPE_GRP_1
 */
 enum CrypterEnum {
    CAESAR(new CrypterCaesar()),SUB(new CrypterSubstitution()),XOR(new CrypterXOR());

    private CrypterCase crypter;

    private CrypterEnum(CrypterCase crypter){
        this.crypter = crypter;
    }

    protected CrypterCase getCrypter() {
        return crypter;
    }
}
