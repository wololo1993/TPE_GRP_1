package tpe_grp_1.uebung1.main;

/**
 * @Author TPE_GRP_1
 */
public class Konto {

    private String inhaber;
    private Waehrung waehrung;
    private String auszug = "";
    private Betrag saldo;


    /**
     * Constructor
     *
     * @param waehrung Waehrung
     * @param inhaber  String
     */
    public Konto(Waehrung waehrung, String inhaber) {
        this.waehrung = waehrung;
        this.inhaber = inhaber;
        this.saldo = new Betrag(0, waehrung);
    }

    /**
     * get Inhaber returns String
     *
     * @return String inhaber
     */
    public String getInhaber() {
        return inhaber;
    }

    /**
     * @return waehrung <b>Waehrung</b>
     */
    public Waehrung getWaehrung() {
        return waehrung;
    }


    /**
     * adds an <i>Betrag</i> to saldo
     *
     * @param betrag Betrag
     */
    public void buche(Betrag betrag) {
        Betrag temp = betrag.umrechnen(waehrung);
        saldo = new Betrag((double) saldo.addiere(temp) / 100, waehrung);
        auszug = auszug.concat(temp.toString() + "\n");
    }

    @Override
    public String toString() {
        return ("Kontoinhaber: " + inhaber + "\n" +
                "Währung: " + waehrung.getName() + "\n"
                + "-----------------\n"
                + auszug
                + "-----------------\n"
                + "Saldo: " + saldo.toString());
    }

    /**
     * promille*saldo
     * promille in promill so 0.001 is 1promill
     *
     * @param promille double
     */
    public void gebuehren(double promille) {
        long gebuehren = (saldo.promille(promille) * saldo.getVorzeichen());
        auszug = auszug.concat("-" + gebuehren + " " + waehrung.getKuerzel() + " (gebuehren)\n");
        saldo = new Betrag(saldo.subtrahiere(gebuehren / 100) / 100, saldo.getWaehrung());
    }

    /**
     * returns double saldo
     *
     * @return double saldo
     */
    public double saldo() {
        return this.saldo.getAsDouble();
    }

}
