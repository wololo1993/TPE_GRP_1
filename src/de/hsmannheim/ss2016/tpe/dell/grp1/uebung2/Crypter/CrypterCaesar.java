package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

/**
 * @Author TPE_GRP_1
 */
class CrypterCaesar extends CrypterCaseCodeA {

    private final int EXPECTEDLENGTH = 1;

    protected CrypterCaesar(Key key) {
        super(key);
    }


    @Override
    public void reset() {

    }

    @Override
    public char verschluesseln(char klartextZeichen) throws CrypterException {
        char erg;

        klartextZeichen = toUpperCase(klartextZeichen);

        if (key.getKey().length() != 1) {
            throw new CrypterException("Wrong Key length, should be : " + EXPECTEDLENGTH + " is : " + this.key.getKey().length());
        }
        erg = getChar(getIndex(klartextZeichen) + (getIndex(key.getKey().charAt(0))));


        return erg;
    }

    @Override
    public char entschluesseln(char cypherTextZeichen) throws CrypterException {
        char erg;

        cypherTextZeichen = toUpperCase(cypherTextZeichen);

        if (key.getKey().length() != 1) {
            throw new CrypterException("Wrong Key length, should be : " + EXPECTEDLENGTH + " is : " + this.key.getKey().length());
        }

        erg = getChar(getIndex(cypherTextZeichen) - getIndex(key.getKey().charAt(0)));

        return erg;

    }

    /**
     * getIndex of Char (char to int)
     *
     * @param c char
     * @return int
     */
    protected int getIndex(char c) {
        return ((int) c) - codeA;
    }

    /**
     * getChar of int (int to char)
     *
     * @param i int
     * @return char
     */
    protected char getChar(int i) {
        while (i > LENGTHA) {
            i = i - LENGTHA;
        }
        while (i < 1) {
            i = LENGTHA + i;
        }
        return (char) (i + codeA);
    }
}
