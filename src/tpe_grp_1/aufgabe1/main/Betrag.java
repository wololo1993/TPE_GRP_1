package tpe_grp_1.aufgabe1.main;

/**
 *
 * @Author TPE_GRP_1
 */
public final class Betrag {

    private final long betrag; //
    private final Waehrung waehrung;

    /**
     * Constructor
     *
     * @param betrag   double
     * @param waehrung Waehrung
     */

    public Betrag(double betrag, Waehrung waehrung) {
        this.betrag = (long) (betrag * 100);
        this.waehrung = waehrung;
    }

    /**
     * returns Betrag
     * get betrag
     *
     * @return long
     */
    public long getBetrag() {
        return betrag;
    }

    /**
     * returns Waehrung
     * get waehrung
     *
     * @return Waehrung
     */
    public Waehrung getWaehrung() {
        return this.waehrung;
    }

    /**
     * adds betrag+b
     *
     * @param b double
     * @return long
     */
    protected long addiere(Betrag b) {
        return (this.betrag + b.betrag);
    }

    /**
     * adds betrag+b
     *
     * @param b double
     * @return long
     */
    protected long addiere(double b) {
        return (this.betrag + (long) (b * 100));
    }


    /**
     * betrag - b
     *
     * @param b Betrag
     * @return double
     */
    protected long subtrahiere(Betrag b) {
        return (this.betrag - b.betrag);
    }

    /**
     * betrag - b
     *
     * @param b double
     * @return double
     */
    protected long subtrahiere(double b) {
        return (this.betrag - (long) (b * 100));
    }

    /**
     * multiply betrag*zahl
     *
     * @param zahl double
     * @return double
     */
    protected double multipliziere(double zahl) {
        return (this.betrag * zahl);
    }

    /**
     * multiply betrag*zahl
     *
     * @param zahl int
     * @return
     */
    protected double multipliziere(int zahl) {
        return (this.betrag * zahl);
    }

    /**
     * return long betrag*prozent
     *
     * @param prozent double
     * @return long
     */
    protected long prozent(double prozent) {
        return (long) (double) ((this.betrag / 100) * prozent) * 100;
    }

    /**
     * returns long
     * betrag * promill
     *
     * @param promill double
     * @return long
     */
    protected long promille(double promill) {
        return (long)(this.betrag * promill);
    }

    /**
     * returns everything before punctuation in int
     *
     * @return int
     */
    public int getVorkomma() {
        return (int) (double) (this.betrag / 100);
    }

    /**
     * returns two digits after punctuation
     *
     * @return int
     */
    public int getNachkomma() {
        return (int) this.betrag % 100;
    }

    @Override
    public String toString() {
        return this.getVorkomma() + "." + this.getNachkomma() * this.getVorzeichen() + " " + waehrung.getKuerzel();
    }

    /**
     * return double
     * returns betrag as double
     *
     * @return double
     */
    public double getAsDouble() {
        return ((double) this.betrag / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Betrag betrag1 = (Betrag) o;

        if (betrag != betrag1.betrag) return false;
        return waehrung != null ? waehrung.equals(betrag1.waehrung) : betrag1.waehrung == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (betrag ^ (betrag >>> 32));
        result = 31 * result + (waehrung != null ? waehrung.hashCode() : 0);
        return result;
    }

    /**
     * returns -1 if saldo is negativ if 0 or positiv returns 1
     *
     * @return int
     */
    public int getVorzeichen() {
        if (this.betrag < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * @param ziel Waehrung
     * @return Betrag
     */
    protected Betrag umrechnen(Waehrung ziel) {
        return new Betrag((double) (waehrung.umrechnen(betrag, ziel)) / 100, ziel);
    }
}
