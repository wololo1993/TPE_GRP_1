package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

/**
 * CrypterCase with CodeA (int of 'A' - 1)
 *
 * @Author TPE_GRP_1
 */

public abstract class CrypterCaseWGet extends CrypterCase {


    /**
     * Constructor
     *
     * @param key Key
     */
    protected CrypterCaseWGet(Key key) {
        super(key);
    }

    /**
     * gets the char from index
     *
     * @param i int
     * @return char
     */
    protected abstract char getChar(int i);

    /**
     * gets Index from char
     *
     * @param c char
     * @return int Index
     */
    protected abstract int getIndex(char c);

}