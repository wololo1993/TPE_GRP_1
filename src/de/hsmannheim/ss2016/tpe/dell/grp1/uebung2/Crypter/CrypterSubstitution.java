package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

/**
 * @Author TPE_GRP_1
 */
class CrypterSubstitution extends CrypterCase {

    private final int EXPECTEDLENGTH = 26;

    protected CrypterSubstitution(Key key) {
        super(key);
    }

    @Override
    public void reset() {
    }

    @Override
    public char verschluesseln(char klartextZeichen) throws CrypterException {

        klartextZeichen = toUpperCase(klartextZeichen);


        if (!keyLengthOK()) {
            throw new CrypterException("Wrong Key length, should be : " + EXPECTEDLENGTH + " is : " + this.key.getKey().length());
        }

        if (isNotValidKey()) {
            throw new CrypterException("Not all Chars in Alphabet in Key");
        }

        int index;

        index = ((int) klartextZeichen) - (((int) 'A'));

        return key.getKey().charAt(index);

    }

    @Override
    public char entschluesseln(char cypherTextZeichen) throws CrypterException {
        cypherTextZeichen = toUpperCase(cypherTextZeichen);
        char erg = 0;


        if (this.key.getKey().length() != LENGTHA) {
            throw new CrypterException("Wrong Key length, should be : " + EXPECTEDLENGTH + " is : " + this.key.getKey().length());
        }

        if (isNotValidKey()) {
            throw new CrypterException("Not whole Alphabet in Key ");
        }

        for (int i = 0; i < key.getKey().length(); i++) {
            if (cypherTextZeichen == key.getKey().charAt(i)) {
                erg = (char) (i + (int) 'A');
                break;
            }
        }


        return erg;
    }

    private boolean keyLengthOK() {
        boolean ok = false;
        if (this.key.getKey().length() == LENGTHA) {
            ok = true;
        }
        return ok;
    }

    private boolean isNotValidKey() {
        boolean isValidKey = false;
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < ALPHABET.length(); i++) {
            int haeufigkeit = 0;
            for (int j = 0; j < key.getKey().length(); j++) {
                if (ALPHABET.charAt(i) == key.getKey().charAt(j)) {
                    haeufigkeit++;
                }
            }
            if (haeufigkeit != 1) {
                isValidKey = true;
            }
        }
        return isValidKey;
    }
}
