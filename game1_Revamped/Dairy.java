package game1_Revamped;

public class Dairy extends items {
    //expiration variable

    private int exp = 1;

    public Dairy(int quality) {
        super("Dairy", quality);
        // TODO Auto-generated constructor stub
    }
    //expiration methods

    public int getExp() {

        return exp;
    }

    public int setExp(int level) {

        exp += level;
        return exp;
    }

    public int daypassed() {
        return exp--;

    }

}
