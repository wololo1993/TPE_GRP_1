package de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.club;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.member.Member;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.member.MembershipList;

public class ClubManagment {

    public static void main(String [] args) {

        MembershipList<Integer, Member> list = new MembershipList();

        list.put(new Member(2, 16, "Mustermann", "Heinz"));
        list.put(new Member(6, 15, "Koch", "Anette"));
        list.put(new Member(5, 9, "Simpson", "Bart"));
        list.put(new Member(4, 5, "Simpson", "Lisa"));

        System.out.println("Länge der Vereinsliste:" + list.size());

        System.out.println(list);

        list.remove(2);

        MembershipList<Integer, Member> list2 = new MembershipList();


        list2.putAll(list);

        list2.put(new Member(2,5,"Simpson","Lisa"));

        System.out.println("\nMember 2 Test:");
        System.out.println("list 1 : " + list.get(2));
        System.out.println("list 2 : " + list2.get(2));
        System.out.println("\nMember 5 Test:");
        System.out.println("list 2 : " + list2.get(5));

        list2.get(5).setVorname("Günther");

        System.out.println("list 2 : "+list2.get(5));

        list2.remove(5);

        System.out.println("\nList 1");
        System.out.println(list);

        System.out.println("\nList 2");
        System.out.println(list2);

        list.clear();

        list2.clear();

        System.out.println("\nLänge Liste 1:" + list.size());
        System.out.println("\nlänge Liste 2:" + list2.size());


    }
}
