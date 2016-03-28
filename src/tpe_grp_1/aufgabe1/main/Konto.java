package tpe_grp_1.aufgabe1.main;

public class Konto {
    private String inhaber;
    private Waehrung waehrung;
    private String auszug="";
    private Betrag saldo;


    public Konto(Waehrung waehrung, String inhaber) {
        this.waehrung = waehrung;
        this.inhaber = inhaber;
        this.saldo = new Betrag(0,waehrung);
    }

    /**
     * get Inhaber returns String
     * @return String inhaber
     */
    public String getInhaber() {
        return inhaber;
    }

    /**
     * get Waehrung returns Waehrung
     * @return waehrung
     */
    public Waehrung getWaehrung() {
        return waehrung;
    }


    // TODO +- beachten (if (add or sub))

    /**
     * adds an <Betrag></Betrag> to saldo
     * @param betrag
     */
    public void buche(Betrag betrag) {

        long value = betrag.getWaehrung().umrechnen(betrag.getBetrag(),waehrung);
        Betrag temp = new Betrag((double)value/100,waehrung);
        saldo = new Betrag((double)saldo.addiere(temp)/100,waehrung);
        auszug = auszug.concat(temp.getAsDouble()+" "+temp.getWaehrung().getKuerzel()+"\n");
    }

    @Override
    public String toString(){
        return ("Kontoinhaber: "+inhaber+"\n"+
                "Währung: "+waehrung.getName()+"\n"
                +"-----------------\n"
                +auszug
                +"-----------------\n"
                +"Saldo: "+saldo.getVorkomma()+"."+saldo.getNachkomma()+" "+saldo.getWaehrung().getKuerzel());
    }

    /**
     * promille/1000*saldo
     * @param promille int
     */
    public void gebuehren(int promille){
        double gebuehren = saldo.getAsDouble()*((double)promille/1000);
        saldo = new Betrag(saldo.getAsDouble()-gebuehren,saldo.getWaehrung());
    }

    /**
     * returns double saldo
     * @return double saldo
     */
    public double saldo(){
        return this.saldo.getAsDouble();
    }

}
