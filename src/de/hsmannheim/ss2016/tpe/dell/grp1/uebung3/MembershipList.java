package de.hsmannheim.ss2016.tpe.dell.grp1.uebung3;

import java.util.*;

public class MembershipList<K, V> extends HashMap<K, V> implements Map<K, V> {

	public V put(Member member) {
		K key = (K) new Integer(member.getIdnr());
		return put(key, (V) member);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
