package tpe_grp_1.uebung1.main;

/**
 *
 * @Author TPE_GRP_1
 */
public class Waehrung {
    private final String name;
    private final String kuerzel;
    private final double kurs; // Wechselkurs zum Dollar

    public String getName() {
        return name;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public double getKurs() {
        return kurs;
    }

    /**
     * Constructor
     *
     * @param name String
     * @param kuerzel String
     * @param kurs double
     */
      public Waehrung(String name, String kuerzel, double kurs) {
      this.name = name;
      this.kuerzel = kuerzel;
      this.kurs = kurs;
      }

     /**
     * takes betrag exchanges it into dollar into target value
     * returns long
     *
     * @param betrag long
     * @param ziel   Waehrung
     * @return long
     */
    public long umrechnen(long betrag, Waehrung ziel) {
        double zielBetrag = betrag;
        zielBetrag = zielBetrag * this.kurs;
        zielBetrag = zielBetrag / ziel.kurs;
        return Math.round(zielBetrag * 100) / 100;
    }

    @Override
    public String toString() {
        return name + " [" + kuerzel + "] 1$ = " + kurs + " " + kuerzel;
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
