package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

/**
 * @Author TPE_GRP_1
 */
class CrypterSubstitution extends CrypterCase {

    private final int EXPECTEDLENGTH = 26; // bezieht sich auf key
    private final int codeAplus1 = codeA + 1; // soll 0 sein wegen string

    /**
     * Constructor
     *
     * @param key Key
     */
    protected CrypterSubstitution(Key key) {
        super(key);
    }

    @Override
    public void reset() {
    }

    @Override
    public char verschluesseln(char klartextZeichen) throws CrypterException {

        klartextZeichen = toUpperCase(klartextZeichen);

        if (key == null) {
            throw new CrypterException("Wrong key : Key is null");
        }

        if (!keyLengthOK()) {
            throw new CrypterException("Wrong Key length in Substi. , should be : " + EXPECTEDLENGTH + " is : " + this.key.getKey().length());
        }

        if (isNotValidKey()) {
            throw new CrypterException("Not all Chars in Alphabet in Key");
        }

        int index;

        index = ((int) klartextZeichen) - (codeAplus1); 

        return key.getKey().charAt(index); // string ist array von char, vertauscht char von 'falschem alpha'  

    }

    @Override
    public char entschluesseln(char cypherTextZeichen) throws CrypterException {
        cypherTextZeichen = toUpperCase(cypherTextZeichen);
        char erg = 0;

        if (key == null) {
            throw new CrypterException("Wrong key : Key is null");
        }
        if (this.key.getKey().length() != LENGTHA) {
            throw new CrypterException("Wrong Key length in Substi. , should be : " + EXPECTEDLENGTH + " is : " + this.key.getKey().length());
        }

        if (isNotValidKey()) {
            throw new CrypterException("Not whole Alphabet in Key ");
        }

        for (int i = 0; i < key.getKey().length(); i++) { // welche position char
            if (cypherTextZeichen == key.getKey().charAt(i)) {  
                erg = (char) (i + codeAplus1);
                break;
            }
        }


        return erg;
    }

    /**
     * Checks if Keylength is okay if not returns false
     *
     * @return boolean
     */
    private boolean keyLengthOK() {
        boolean ok = false;
        if (this.key.getKey().length() == LENGTHA) {
            ok = true;
        }
        return ok;
    }

    /**
     * Checks if whole Alphabet is in key return true if not valid
     *
     * @return boolean
     */
    private boolean isNotValidKey() { // jeder buchstabe nur 1 mal?
        boolean isValidKey = false;
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < ALPHABET.length(); i++) { // durchläuft alphabet
            int haeufigkeit = 0;
            for (int j = 0; j < key.getKey().length(); j++) {
                if (ALPHABET.charAt(i) == key.getKey().charAt(j)) { // durchläuft ganzen key
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
