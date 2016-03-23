
public class Waehrung extends Waehrungen{
	private String name;
	private String kuerzel;
	private double kurs; // Wechselkurs zum Dollar
	
	public String getName() {
		return name;
	}

	public String getKuerzel() {
		return kuerzel;
	}
	
	public double getKurs() {
		return kurs;
	}

	public static void main (String[] arg){
		
	}
	
	public Waehrung(String name, String kuerzel, double kurs) {
		this.name = name;
		this.kuerzel = kuerzel;
		this.kurs = kurs;
	}
	
	public long umrechnen(long in,Waehrung ziel){
		double zielBetrag = in;
		zielBetrag = zielBetrag * this.kurs;
		zielBetrag = zielBetrag / ziel.kurs;
		return (long) Math.round(zielBetrag * 100)/100;
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
}
