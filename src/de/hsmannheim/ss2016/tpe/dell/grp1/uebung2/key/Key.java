package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key;

/**
 * Key der einen String enthält
 */
public class Key<T> {
    private T key;

    /**
     * Erstellt neuen key mit String
     * @param key String
     */
    public Key(T key){
        this.key = key;
    }

    /**
     * get key returns to String
     * @return String
     */
    public String getKey() {
        return toString();
    }

    @Override
    public String toString(){
        return key.toString();
    }
}
