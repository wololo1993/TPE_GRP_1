package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

/**
 * CrypterCase with CodeA (int of 'A' - 1)
 *
 * @Author TPE_GRP_1
 */

public abstract class CrypterCaseCodeA extends CrypterCase {
    protected final int codeA = ((int) 'A') - 1;

    protected CrypterCaseCodeA(Key key) {
        super(key);
    }

    protected abstract char getChar(int i);

    protected abstract int getIndex(char c);

}
