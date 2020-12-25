package game1_Revamped;

public abstract class Upgradable {
//upgradable, costs and upgrade. Could probably have made this an interface
    public abstract int upgrade();

    public int getCost(int n) {

        return n * 100;

    }

}
