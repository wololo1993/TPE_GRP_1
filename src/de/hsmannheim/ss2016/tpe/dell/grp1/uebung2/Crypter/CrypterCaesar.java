package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.exeption.CrypterException;
/**
 * @Author TPE_GRP_1
 */
class CrypterCaesar extends CrypterCase {

   @Override
   public void reset() {

   }

   @Override
   public char verschluesseln(char klartextZeichen) throws CrypterException {
       toUpperCase();
       char erg = 0;
       try {
           if (key.getKey().length() != 1) {
               throw new CrypterException();
           }
          erg = getChar(getIndex(klartextZeichen) + (getIndex(key.getKey().charAt(0))));

       } catch (CrypterException e) {
           System.out.println("Key ist falsch" + e);
       }
       return erg;
   }

   @Override
   public char entschluesseln(char cypherTextZeichen) throws CrypterException {
       toUpperCase();
       char erg = 0;

       try {
           if (key.getKey().length() != 1) {
               throw new CrypterException();
           }

           erg = getChar(getIndex(cypherTextZeichen)-getIndex(key.getKey().charAt(0)));
       } catch (CrypterException e) {
           System.out.println("Key ist falsch : "+this.key+"\n@"+this.chara+"\n"+ e);
       }
       return erg;
   }

    /**
     *
     * getIndex of Char (char to int)
     * @param c char
     * @return int
     */
   private int getIndex(char c){
       int i = ((int)c)-codeA;
       return i;
   }

    /**
     * getChar of int (int to char)
     * @param i int
     * @return char
     */
   private char getChar(int i){
       while(i > LENGTHA){
           i = i - LENGTHA;
       }
       while(i < 1){
           i = LENGTHA +i;
       }
       return (char)(i+codeA);
   }
}
