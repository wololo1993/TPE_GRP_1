package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key;


/**
 * Key< T >der einen String enthält
 */
public class Key<T> {

    private final T key;  // Key hat kleinen key vom typ T

    /**
     * Erstellt neuen key mit String
     *
     * @param key String
     */
    public Key(T key) {
        this.key = key;
    }

    /**
     * get key returns to String
     *
     * @return String
     */
    public String getKey() {
        return toString().toUpperCase();
    }

    @Override
    public String toString() {
        return key.toString(); // funktioniert nur mit objekttypen
    }
}
