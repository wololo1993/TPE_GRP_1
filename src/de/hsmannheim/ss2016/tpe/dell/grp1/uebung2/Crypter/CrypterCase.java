package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.crypter;

 import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.exeption.CrypterException;
 import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key.Key;
/**
 * @Author TPE_GRP_1
 */
abstract class CrypterCase implements Crypter {

    protected Key key;
    protected char chara;
    protected final int LENGTHA = 26;
    protected final int codeA =((int) 'A') - 1;

    /**
     * set Key
     * @param key Key
     */
    protected void setKey(Key key){
        this.key = key;
    }

    /**
     * casts this.char to uppercase
     */
    protected void toUpperCase(){
        this.chara =((chara+"").toUpperCase()).charAt(0);
    }


    @Override
    public abstract void reset();

    @Override
    public abstract char verschluesseln(char klartextZeichen) throws CrypterException;

    @Override
    public abstract char entschluesseln(char cypherTextZeichen) throws CrypterException;

}
