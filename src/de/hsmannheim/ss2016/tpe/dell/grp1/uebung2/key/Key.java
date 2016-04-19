package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.key;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.exeption.CrypterException;

/**
 * Key< T >der einen String enthält
 */
public class Key<T> {

    private final T key;

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
        return key.toString();
    }
}
