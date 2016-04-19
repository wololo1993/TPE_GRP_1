package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

/**
 * Parent Class of the CrypterTypes
 *
 * @Author TPE_GRP_1
 */
abstract class CrypterCase implements Crypter {

    protected Key key;
    protected final int LENGTHA = 26;
    protected final int codeA = ((int) 'A') - 1;

    /**
     *  Constructor
     *
     * @param key Key
     */
    protected CrypterCase(Key key) {
        this.key = key;
    }


    /**
     * casts char a to upperCase
     *
     * @param a char
     * @return char a in uppercase
     */
    protected char toUpperCase(char a) {
        return ((a + "").toUpperCase()).charAt(0);
    }

    @Override
    public abstract void reset();

    @Override
    public abstract char verschluesseln(char klartextZeichen) throws CrypterException;

    @Override
    public abstract char entschluesseln(char cypherTextZeichen) throws CrypterException;


}
