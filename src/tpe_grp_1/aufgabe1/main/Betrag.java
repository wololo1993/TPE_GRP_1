package tpe_grp_1.aufgabe1.main;

public class Betrag {

    protected long betrag; //
    private final Waehrung waehrung;

    Betrag(double betrag, Waehrung waehrung) {
        this.betrag = (long) (betrag * 100);
        this.waehrung = waehrung;
    }

    public long getBetrag() {
        return betrag;
    }

    public Waehrung getWaehrung() {
        return this.waehrung;
    }

    public long addiere(Betrag b) {
        return (this.betrag + b.betrag);
    }

    double subtrahiere(Betrag b) {
        return (this.betrag - b.betrag);
    }

    double multipliziere(double zahl) {
        double ergebnis = (this.betrag * zahl);
        return ergebnis;
    }

    double multipliziere(int zahl) {
        double ergebnis = (this.betrag * zahl);
        return ergebnis;
    }

    long prozent(double prozent) {
        double prozentwert = (this.betrag / 100) * prozent;
        return (long) (prozentwert * 100);
    }

    long promille(double promill) {
        double promillewert = ((this.betrag / 100) * promill);
        return (long) (promillewert * 100);
    }

    int getVorkomma() {
        double vorKomma = (this.betrag / 100);
        return (int) vorKomma;
    }

    int getNachkomma() {
        return (int) this.betrag % 100;
    }

    public String toString() {
        return getVorzeichen() * betrag + " " + waehrung;
    }

    double getAsDouble() {

        double doubleZahl = this.betrag;
        return (doubleZahl / 100);
    }


//	public boolean equals(Object o) {
//   TODO
//	}

    int getVorzeichen() {
        if (betrag <= 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
