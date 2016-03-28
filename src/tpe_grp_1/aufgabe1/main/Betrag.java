package tpe_grp_1.aufgabe1.main;

public class Betrag {

    private final long betrag; //
    private final Waehrung waehrung;
    private final int vorzeichen;

    public Betrag(double betrag, Waehrung waehrung) {
        if(betrag < 0){
            vorzeichen = -1;
        } else{
            vorzeichen = 1;
        }
        this.betrag = (long) (betrag * 100);
        this.waehrung = waehrung;
    }

    /**
     * returns Betrag
     * get betrag
     * @return
     */
    public long getBetrag() {
        return betrag;
    }

    /**
     * returns Waehrung
     * get waehrung
     * @return
     */
    public Waehrung getWaehrung() {
        return this.waehrung;
    }

    /**
     * returns long
     * adds betrag+b
     * @param b
     * @return
     */
    public long addiere(Betrag b) {
        return (this.betrag + b.betrag);
    }

    /**
     * returns double
     * betrag - b
     * @param b
     * @return
     */
    double subtrahiere(Betrag b) {
        return (this.betrag - b.betrag);
    }

    /**
     * returns double
     * multiply betrag*zahl
     * @param zahl
     * @return
     */
    double multipliziere(double zahl) {
        double ergebnis = (this.betrag * zahl);
        return ergebnis;
    }

    /**
     * returns double
     * multiply betrag*zahl
     * @param zahl
     * @return
     */
    double multipliziere(int zahl) {
        double ergebnis = (this.betrag * zahl);
        return ergebnis;
    }

    /**
     * return long betrag*prozent
     * @param prozent
     * @return
     */
    long prozent(double prozent) {
        double prozentwert = (this.betrag / 100) * prozent;
        return (long) (prozentwert * 100);
    }

    /**
     * returns long
     * betrag * promill
     * @param promill
     * @return
     */
    long promille(double promill) {
        double promillewert = ((this.betrag / 100) * promill);
        return (long) (promillewert * 100);
    }

    /**
     * returns everything before punktation in int
     * @return
     */
    public int getVorkomma() {
        double vorKomma = (this.betrag / 100);
        return (int) vorKomma;
    }

    /**
     * returns .00 as int
     * @return
     */
    public int getNachkomma() {
        return (int) this.betrag % 100;
    }

    @Override
    public String toString() {
        return getVorzeichen() * betrag + " " + waehrung;
    }

    /**
     * return double
     * returns betrag as double
     * @return
     */
    public double getAsDouble() {

        double doubleZahl = this.betrag;
        return (doubleZahl / 100)*vorzeichen;
    }


//	public boolean equals(Object o) {
//   TODO
//	}

    /**
     * return int returns -1 if <saldo></saldo> is negativ if 0 or positiv returns 1
     * @return
     */
    public int getVorzeichen() {
        return vorzeichen;
    }
}
