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

    public String getInhaber() {
        return inhaber;
    }

    public Waehrung getWaehrung() {
        return waehrung;
    }


    // TODO +- beachten (if (add or sub))
    public void buche(Betrag betrag) {
        long value = betrag.getWaehrung().umrechnen(betrag.getVorkomma()*100+betrag.getNachkomma(),waehrung);
        Betrag temp = new Betrag((double)value*betrag.getVorzeichen()/100,waehrung);
        long baba = saldo.addiere(temp);
        auszug = auszug.concat(temp.getVorkomma()*temp.getVorzeichen()+"."+temp.getNachkomma()+" "+temp.getWaehrung());
        saldo = new Betrag(baba,waehrung);
    }
    @Override
    public String toString(){
        return ("Kontoinhaber: "+inhaber+"\n"+
                "Währung: "+waehrung.getName()+"\n"
                +"-----------------\n"
                +auszug
                +"-----------------\n"
                +"Saldo: "+saldo);
    }

    public void gebuehren(){

    }


    public double saldo(){
        return ((double)saldo.getVorkomma()*saldo.getVorzeichen())+(saldo.getNachkomma()/100);
    }
}
