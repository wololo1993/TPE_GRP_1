package de.hsmannheim.ss2016.tpe.dell.grp1.uebung3.member;

/**
 * hat id,jahre im verein, name,nachname
 *
 * @Author TPE_GRP_1
 */
public class Member {
    private int idnr;
    private int jahreVerein;
    private String name;
    private String vorname;

    /**
     * Konstruktor
     *
     * @param idnr        Int
     * @param jahreVerein Int
     * @param name        String
     * @param vorname     String
     */
    public Member(int idnr, int jahreVerein, String name, String vorname) {
        this.idnr = idnr;
        this.jahreVerein = jahreVerein;
        this.name = name;
        this.vorname = vorname;
    }


    public String toString() {
        return "id: " + idnr + "; Nachname: " + name + "; Vorname: " + vorname + "; Jahre im Verein: " + jahreVerein+";";
    }

    /**
     * getID
     *
     * @return id Int
     */
    public int getIdnr() {
        return idnr;
    }

    /**
     * set Vorname
     *
     * @param vorname String
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * set JahreVerein
     *
     * @param jahreVerein Int
     */
    public void setJahreVerein(int jahreVerein) {
        this.jahreVerein = jahreVerein;
    }

    /**
     * get Nachname
     *
     * @return name String
     */
    public String getNachname() {
        return name;
    }

    /**
     * get Vorname
     *
     * @return vorname String
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * get JahreimVerein
     *
     * @return jahreVerein Int
     */
    public int getJahreVerein() {
        return jahreVerein;
    }

    /**
     * setNachname
     *
     * @param name String
     */
    public void setNachname(String name) {this.name = name; }
}
