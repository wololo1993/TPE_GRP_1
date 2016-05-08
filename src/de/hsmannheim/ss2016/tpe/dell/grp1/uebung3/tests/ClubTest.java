package de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.tests;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.member.Member;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.member.MembershipList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClubTest {

    private final static int LIST_LENGTH = 8;

    MembershipList cm = new MembershipList(LIST_LENGTH);

    @Before
    public void setUp(){

        Member m1 = new Member(1,88,"Ihme","Fabian");
        Member m2 = new Member(3,37,"Ihme","Fabiihme");
        Member m3 = new Member(5,412,"Ihme","Fabio");
        Member m4 = new Member(6,44,"Ihme","Fag");


        cm.put(m1);
        cm.put(m2);
        cm.put(m3);
        cm.put(m4);

    }

    @Test
    public void testAdd(){

        Member m1 =new Member(2,3,"JOJO","Tiebert");
        Member m2 = new Member(4,24,"bla","blublub");

        cm.put(m1);
        cm.put(4,m2);

        assertEquals(cm.get(4),m2);
        assertEquals(cm.get(2),m1);

        Member m3 = new Member(2,4,"Blabla","Trololo");

        cm.put(m3);

        assertEquals(m1,cm.get(2));


        System.out.println(cm);
    }

    @Test
    public void testRemove(){
        cm.remove(1);

        assertEquals(null,cm.get(1));
    }

    @Test
    public void testGetter(){
        assertEquals(1,((Member)cm.get(1)).getIdnr());
        assertEquals(88,((Member)cm.get(1)).getJahreVerein());
        assertEquals("Ihme",((Member)cm.get(1)).getNachname());
        assertEquals("Fabian",((Member)cm.get(1)).getVorname());
    }

    @Test
    public void testSetter(){

        ((Member)cm.get(1)).setJahreVerein(4);
        ((Member)cm.get(1)).setNachname("Gauss");
        ((Member)cm.get(1)).setVorname("Gunther");


        assertEquals(4,((Member)cm.get(1)).getJahreVerein());
        assertEquals("Gauss",((Member)cm.get(1)).getNachname());
        assertEquals("Gunther",((Member)cm.get(1)).getVorname());
    }

    @Test
    public void testToString(){
        assertEquals("id: 1 Nachname: Ihme Vorname: Fabian Jahre im Verein: 88",((Member)cm.get(1)).toString());
    }

    @Test
    public void testSize(){
        assertEquals(4,cm.size());
        cm.put(new Member(7,38,"hi","ho"));
        assertEquals(5,cm.size());

    }

    @Test
    public void testClear(){
        cm.clear();
        assertEquals(0,cm.size());
    }

    @Test
    public void test(){
        cm.clear();

        for(int i = 0; i < 200; i++){
            cm.put(i,null);
        }

        System.out.println(cm);
    }





}
