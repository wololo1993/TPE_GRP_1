package de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.member;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.member.Member;

import java.util.*;

/**
 * @param <K> Key
 * @param <V> Value
 * @Author TPE_GRP_1
 */
public class MembershipList<K, V> extends HashMap<K, V> implements Map<K, V> {

    /**
     * konstruktor mit Groesse der liste
     *
     * @param i groesse
     */
    public MembershipList(int i) {
        super(i);
    }

    /**
     * default konstruktor übergibt grösse 16
     */
    public MembershipList() {
        super();
    }

    /**
     * put(K,V) nur wenn key noch nicht vorhanden ansonsten return null;
     *
     * @param key
     * @param value
     * @return V or null if k already exists
     */
    @Override
    public V put(K key, V value) {
        if (this.containsKey(key)) {
            return null;
        }
        return super.put(key, value);
    }

    /**
     * put(Member) ruft put(K,V) auf
     *
     * @param member
     * @return V or null if K already exists
     */
    public V put(Member member) {
        K key = (K) new Integer(member.getIdnr());
        return put(key, (V) member);
    }


    @Override
    public String toString() {
        String s = "{\n";
        for (Map.Entry<K, V> entry : this.entrySet()) {
            if (entry.getValue() == null) {
                s = s + "id : " + entry.getKey() + "; is empty\n";
            } else {
                s = s + entry.getValue() + "\n";
            }
        }
        s = s + "}";

        return s;
    }

}
