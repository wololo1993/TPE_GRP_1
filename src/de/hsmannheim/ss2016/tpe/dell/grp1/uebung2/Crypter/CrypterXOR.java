package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Exeption.CrypterException;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;

@SuppressWarnings("ALL")
 class CrypterXOR extends CrypterCase {
    private int position=0;
    private int codeA =((int)'A')-1;
    private char[] buchstabenZeichen = buchstabenZeichen();

    private char[] buchstabenZeichen(){
        char [] buchstabenZeichen = new char[32];
        for(int i = 1; i < LENGTHA +1 ; i++){
            buchstabenZeichen[i]=(char)(((int)'A'-1)+i);
        }
        buchstabenZeichen[0] = '@';
        buchstabenZeichen[27]='[';
        buchstabenZeichen[28]='\\';
        buchstabenZeichen[29]=']';
        buchstabenZeichen[30]='^';
        buchstabenZeichen[31]='_';

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
        erg = aXorB(klartextZeichen,key.getKey().charAt(position));
        position++;
        return erg;
    }

    @Override
    public char entschluesseln(char cypherTextZeichen) throws CrypterException {
        char erg;
        checkKeyLength();
        erg = aXorB(cypherTextZeichen,key.getKey().charAt(position));
        position++;
        return erg;
    }

    /**
     * (aC^bC)
     * also fuer verschluesseln (klartextZeichen,key)
     * anderstrum fuers entschluesseln (key , cyphertextZeichen)
     * @param aC first
     * @param bC second
     * @return char
     */
    private char aXorB(char aC,char bC){
         int aI = getIndex(aC);
        int bI = getIndex(bC);
        char erg = getChar(aI^bI);
        return erg;
    }

    private void checkKeyLength(){
        while(position >= key.getKey().length()){
            key = new Key(key.getKey()+key.getKey());
        }
    }

    private int getIndex(char c){
        for(int i = 0; i < buchstabenZeichen.length; i++){
            if(c == buchstabenZeichen[i]){
                return i;
            }
        }
        return 0;
    }

    private char getChar(int i){
        return buchstabenZeichen[i];
    }

    public void printTest(){
        char aC = 'S';
        char bC = 'E';
        System.out.println("Char a = "+aC);
        System.out.println("Char key = "+bC);
        System.out.println();
        int aI = getIndex(aC);
        int bI = getIndex(bC);
        System.out.println("Index a = "+aI);
        System.out.println("Index key = "+bI);

        int abI = (bI^aI);
        char abC = getChar(abI);

        System.out.println("Erg Int = "+abI);
        System.out.println("Erg Char = "+ abC);

        System.out.println();
        System.out.println("");

    }
}
