package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

class CrypterXOR extends CrypterCase {
    private int position = 0;
    private char[] buchstabenZeichen = buchstabenZeichen();

    private char[] buchstabenZeichen() {
        char[] buchstabenZeichen = new char[32];
        for (int i = 1; i < LENGTHA + 1; i++) {
            buchstabenZeichen[i] = (char) (codeA + i);
        }
        buchstabenZeichen[0] = '@';
        buchstabenZeichen[27] = '[';
        buchstabenZeichen[28] = '\\';
        buchstabenZeichen[29] = ']';
        buchstabenZeichen[30] = '^';
        buchstabenZeichen[31] = '_';

        return buchstabenZeichen;

    }

    @Override
    public void reset() {
        this.position = 0;
    }


    @Override
    public char verschluesseln(char klartextZeichen) throws CrypterException {
        char erg;
        checkKeyLength();
        erg = aXorB(klartextZeichen, key.getKey().charAt(position));
        position++;
        return erg;
    }

    @Override
    public char entschluesseln(char cypherTextZeichen) throws CrypterException {
        return verschluesseln(cypherTextZeichen);
    }

    /**
     * (aC^bC)
     * also fuer verschluesseln (klartextZeichen,key)
     * anderstrum fuers entschluesseln (key , cyphertextZeichen)
     *
     * @param aC first
     * @param bC second
     * @return char
     */
    private char aXorB(char aC, char bC) {
        int aI = getIndex(aC);
        int bI = getIndex(bC);
        char erg = getChar(aI ^ bI);
        return erg;
    }

    /**
     * if key to short add the same key until long enough
     */
    private void checkKeyLength() {
        while (position >= key.getKey().length()) {
            key = new Key(key.getKey() + key.getKey());
        }
    }

    /**
     * gets the index
     *
     * @param c char
     * @return int
     */
    private int getIndex(char c) {
        for (int i = 0; i < buchstabenZeichen.length; i++) {
            if (c == buchstabenZeichen[i]) {
                return i;
            }
        }
        return 0;
    }

    private char getChar(int i) {
        return buchstabenZeichen[i];
    }
}
