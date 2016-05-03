package de.hsmannheim.ss2016.tpe.dell.grp1.uebung3;

public class Member {
	private int idnr;
	private int jahreVerein;
	private String name;
	private String vorname;

	public Member(int idnr, int jahreVerein, String namee, String vorname) {
		this.idnr = idnr;
		this.jahreVerein = jahreVerein;
		this.name = name;
		this.vorname = vorname;
	}

	public String toString() {
		return "idnr" + idnr + " Nachname: " + name + " Vorname: " + vorname + " Jahre im Verein: " + jahreVerein;
	}

	public int getIdnr() {
		return idnr;
	}

	public void setIdnr() {
		this.idnr = idnr;
	}

	public void setVornamw() {
		this.vorname = vorname;
	}

	public void setJahreVerein(int jahreVerein) {
		this.jahreVerein = jahreVerein;
	}

	public String getNachname() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public int getJahreVerien() {
		return jahreVerein;
	}

	public void setNachname() {
		this.name = name;
	}
}
