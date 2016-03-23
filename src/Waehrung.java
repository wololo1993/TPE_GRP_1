
public class Waehrung extends Waehrungen{
	private String name;
	private String kuerzel;
	private double kurs; // Wechselkurs zum Dollar

	public static void main (String[] arg){
		
		
		Waehrung w1 = new Waehrung("Dollar","$",1);
		Waehrung w2 = new Waehrung("Rubel","RUB",0.0141);
		Waehrung w3 = new Waehrung("Euro","€",1.1086);
		Waehrung w4 = new Waehrung("Yen","¥",0.0091);
		Waehrung w5 = new Waehrung("SFranken","CHF",1.0509);
		
		
		Betrag bla = new Betrag(200,Waehrungen.dollar);
		
		System.out.println(bla.umrechnen(Waehrungen.euro));
		
		
//		System.out.println(w1+"\n"+w2+"\n"+w3.umrechnen(20, w2));
//		
//		System.out.println("A= "+(20*1.1086)/0.0141);
	}
	
	
	public Waehrung() {
	}

	public Waehrung(String name, String kuerzel, double kurs) {
		this.setName(name);
		this.setKuerzel(kuerzel);
		this.setKurs(kurs);
	}
	
	public long umrechnen(long in,Waehrung ziel){
		return(long)((in*(double)this.kurs)/ziel.kurs);
	}


	public String toString(){
		return name+" ["+kuerzel+"] 1$ = "+kurs+" "+kuerzel;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kuerzel == null) ? 0 : kuerzel.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waehrung other = (Waehrung) obj;
		if (kuerzel == null) {
			if (other.kuerzel != null)
				return false;
		} else if (!kuerzel.equals(other.kuerzel))
			return false;
		if (Double.doubleToLongBits(kurs) != Double.doubleToLongBits(other.kurs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	public double getKurs() {
		return kurs;
	}

	public void setKurs(double kurs2) {
		this.kurs = kurs2;
	}
	

}
