package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Exeption.CrypterException;

/**
 *
 */
 class CrypterSubstitution extends CrypterCase {
    @Override
    public void reset() {

    }

    @Override
    public char verschluesseln(char klartextZeichen) throws CrypterException {

        try {
            if(this.key.getKey().length() != LENGTHA){
                throw new CrypterException();
            }
        } catch (CrypterException e){
            System.out.println("ERROR @verschluesseln Wrong Key "+key);
            return 0;
        }
        int index = ((int)klartextZeichen)-(((int)'A'));
        return key.getKey().charAt(index);
    }

    @Override
    public char entschluesseln(char cypherTextZeichen) throws CrypterException {
        char erg = 0;

        try {
            if(this.key.getKey().length() != LENGTHA){
                throw new CrypterException();
            }
        } catch (CrypterException e){
            System.out.println("ERROR @verschluesseln Wrong Key "+key);
            return erg;
        }

        for(int i = 0; i<key.getKey().length();i++){
            if(cypherTextZeichen==key.getKey().charAt(i)){
                erg = (char)(i+(int)'A');
                break;
            }
        }
        return erg;
    }
}
