package de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Crypter;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung2.Exeption.CrypterException;

/**
 * Grundlegendes Interface, um Verschl̈usselung durchzuf̈uhren. Mit
 * Hilfe dieses Interfaces kann man Nachrichten verschl̈usseln ( ̈uber die
 * {@link #verschluesseln(char)} Methode) und wieder entschl̈usseln ( ̈uber die
 * {@link #entschluesseln(char)} Methode).
 *
 * Der Eingabetext, der Zeichenweise  ̈ubergeben wird ({@literal klarTextZeichen})
 * darf nur aus den Groß-Buchstaben A-Z bestehen. Kleinbuchstaben werden in
 * Großbuchstaben umgewandelt, alle anderen Zeichen f̈uhren zu einer Ausnahme.
 * Zwischen den beiden Methoden muss bei gleichem Schl̈ussel folgendes gelten:
 * {@code zeichen == decrypt(encrypt(zeichen))}.
 *
 */
public interface Crypter {
    /**
     * Setzt die Verschl̈usselung zur̈uck. Diese Methode ist bei einigen
     * Verfahren sinnvoll, bei denen eine Position im Schl̈ussel verwaltet
     * wird, da diese beim Wechsel von Ver- auf Entschl̈usselung zur̈uckgesetzt
     * werdem muss.
     */
    public void reset();
    /**
     * Verschl̈usselt das gegebene Zeichen.
     * @param klartextZeichen Zeichen, das verschl̈usselt werden soll.
     * @return verschl̈usseltes Zeichen.
     * @throws CrypterException Wird geworfen, wenn Probleme mit der
     * Verschlüsselung auftreten. */
    public char verschluesseln(char klartextZeichen) throws CrypterException;
    /**
     * Entschl ̈usselt das gegebenen Zeichen.
     * @param cypherTextZeichen Zeichen, das entschl ̈usselt werden soll.
     * @return entschl̈usseltes Zeichen.
     * @throws CrypterException Wird geworfen, wenn Probleme mit der
     * Verschl̈usselung auftreten.
     */
    public char entschluesseln(char cypherTextZeichen) throws CrypterException;
}

