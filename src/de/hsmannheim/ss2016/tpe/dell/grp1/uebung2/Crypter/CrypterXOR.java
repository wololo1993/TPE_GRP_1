package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

class CrypterXOR extends CrypterCaseWGet {
    private int position = 0;
    private final char[] BUCHSTABENZEICHEN =  buchstabenZeichen();

    /**
     * Constructor
     *
     * @param key Key
     */
    protected CrypterXOR(Key key) {
        super(key);
    }

    /**
     * crates char array BUCHSTABENZEICHEN
     *
     * @return
     */
    private char[] buchstabenZeichen() {
        char[] buchstabenZeichen = new char[32];
        for (int i = 1; i <= LENGTHA; i++) {
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
        klartextZeichen = toUpperCase(klartextZeichen);
        if (key == null) {
            throw new CrypterException("Wrong key : Key is null");
        }
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
        return getChar(aI ^ bI);
    }

    /**
     * if key to short add the same key until long enough
     */
    private void checkKeyLength() {
        while (position >= key.getKey().length()) {
            key = new Key<>(key.getKey() + key.getKey());
        }
    }


    protected int getIndex(char c) {
        for (int i = 0; i < BUCHSTABENZEICHEN.length; i++) {
            if (c == BUCHSTABENZEICHEN[i]) {
                return i;
            }
        }
        return 0;
    }

    protected char getChar(int i) {
        return BUCHSTABENZEICHEN[i];
    }
}
