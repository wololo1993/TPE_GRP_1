package de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.tests;

import de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.club.ClubManagment;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.member.Member;
import de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.member.MembershipList;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class ClubTest {

    private final static int LIST_LENGTH = 8;

    MembershipList cm = new MembershipList(LIST_LENGTH);

    @Before
    public void setUp() {

        Member m1 = new Member(1, 88, "Dauß", "Dieter");
        Member m2 = new Member(3, 37, "Ihme", "Inga");
        Member m3 = new Member(5, 412, "Hoggert", "Hubert");
        Member m4 = new Member(6, 44, "Felizi", "Felix");


        cm.put(m1);
        cm.put(m2);
        cm.put(m3);
        cm.put(m4);

    }

    @Test
    public void testAdd() {

        Member m1 = new Member(2, 3, "JOJO", "Tiebert");
        Member m2 = new Member(4, 24, "bla", "blublub");

        cm.put(m1);
        cm.put(4, m2);

        assertEquals(cm.get(4), m2);
        assertEquals(cm.get(2), m1);

        Member m3 = new Member(2, 4, "Blabla", "Trololo");

        cm.put(m3);

        assertEquals(m1, cm.get(2));


        System.out.println(cm);
    }

    @Test
    public void testRemove() {
        cm.remove(1);
        assertEquals(null, cm.get(1));
    }

    @Test
    public void testGetter() {
        assertEquals(1, ((Member) cm.get(1)).getIdnr());
        assertEquals(88, ((Member) cm.get(1)).getJahreVerein());
        assertEquals("Dauß", ((Member) cm.get(1)).getNachname());
        assertEquals("Dieter", ((Member) cm.get(1)).getVorname());
    }

    @Test
    public void testSetter() {

        ((Member) cm.get(1)).setJahreVerein(4);
        ((Member) cm.get(1)).setNachname("Gauss");
        ((Member) cm.get(1)).setVorname("Gunther");


        assertEquals(4, ((Member) cm.get(1)).getJahreVerein());
        assertEquals("Gauss", ((Member) cm.get(1)).getNachname());
        assertEquals("Gunther", ((Member) cm.get(1)).getVorname());
    }

    @Test
    public void testToString() {
        assertEquals("id: 1; Nachname: Dauß; Vorname: Dieter; Jahre im Verein: 88;", cm.get(1).toString());

    }

    @Test
    public void testSize() {
        assertEquals(4, cm.size());
        cm.put(new Member(7, 38, "hi", "ho"));
        assertEquals(5, cm.size());

    }

    @Test
    public void testClear() {
        cm.clear();
        assertEquals(0, cm.size());
    }

    @Test
    public void testEqualsHashCode() {
        assertEquals(cm.get(3), new Member(3, 37, "Ihme", "Inga"));
        assertFalse(cm.get(3) == new Member(3, 37, "Ihme", "Inga"));

        assertEquals(cm.get(3).hashCode(), (new Member(3, 37, "Ihme", "Inga").hashCode()));
    }

    @Test
    public void testAddAll() {
        MembershipList cm2 = new MembershipList<Integer, Member>();
        cm2.putAll(cm);
        assertEquals(cm, cm2);
    }

    @Test
    public void testEqualsExeption() {
        try {
            cm.get(2).equals(null);
            fail();
        } catch (Exception e) {

        }
    }

    /**
     * Testet ClubManagement hat dementsprechend Consolenausgabe
     */
    /*
    @Test
    public void testClubManagement() {

        ClubManagment.main(null);
    }*/


}
