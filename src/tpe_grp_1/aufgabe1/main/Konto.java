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
     * @return
     */
    public String getInhaber() {
        return inhaber;
    }

    /**
     * get Waehrung returns Waehrung
     * @return
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
        String vorzeichen;
        if(betrag.getVorzeichen()==-1) {
            vorzeichen ="-";
        } else {
            vorzeichen ="+";
        }
        long value = betrag.getWaehrung().umrechnen(betrag.getBetrag(),betrag.getWaehrung());
        Betrag temp = new Betrag((double)value/100*betrag.getVorzeichen(),waehrung);
        long baba = saldo.addiere(temp);
        auszug = auszug.concat(vorzeichen+temp.getVorkomma()+"."+temp.getNachkomma()+" "+temp.getWaehrung().getKuerzel()+"\n");
        saldo = new Betrag((double)baba/100*saldo.getVorzeichen(),waehrung);
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
     * @return
     */
    public double saldo(){
        return ((double)saldo.getVorkomma()*saldo.getVorzeichen())+(saldo.getNachkomma()/100);
    }

    private double getBetragDouble(){
        return (double)saldo.getBetrag()/100*saldo.getVorzeichen();
    }
}