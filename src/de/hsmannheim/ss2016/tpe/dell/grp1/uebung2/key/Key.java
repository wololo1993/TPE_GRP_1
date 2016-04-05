package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key;

/**
 * Key der einen String enthält
 */
public class Key {
    private String key;

    /**
     * Erstellt neuen key mit String
     * @param key String
     */
    public Key(String key){
        this.key = key;
    }

    /**
     * get key
     * @return Key
     */
    public String getKey() {
        return key;
    }

    @Override
    public String toString(){
        return key;
    }
}
