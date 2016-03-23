
public class Betrag {

	private final long betrag;
	private final String waehrung;
	
	public Betrag(double betrag, String waehrung){
		this.betrag = (long) (betrag * 100);
		this.waehrung = waehrung;
	}
	
	public long addiere(Betrag b){
		return (this.betrag + b.betrag);
	}
	
	public long subtrahiere(Betrag b){
		return (this.betrag - b.betrag);
	}
	
	int getVorkomma1(){
		if (this.betrag <= 0){
			return -1;
		}else{
			return 1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	double prozent(double prozentsatz){
		double prozentwert = this.betrag * prozentsatz;
		return prozentsatz;
	}
	
	double promille(double promillsatz){
		double promilltwert = (this.betrag * promillsatz)/1000;
		return promillsatz;
	}
	
	double getVorkomma(){
		int vorKomma = (int) this.betrag;
		return vorKomma;
	}

}
