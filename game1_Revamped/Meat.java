package game1_Revamped;

public class Meat extends items {
    //epiration date + quality

    private int exp;
    private int Q;

    public Meat(int quality) {
        super("Meat", quality);
        this.Q = quality;
        this.exp = 2;
    }

    //expiration methods
    public int daypassed() {

        return exp--;
    }

    public int getExp() {
        return exp;

    }

    public int setExp(int level) {
        exp += level;
        return exp;
    }

}
