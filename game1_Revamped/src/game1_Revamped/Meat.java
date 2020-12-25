package game1_Revamped;

public class Meat extends items {

	private int exp;
	private int Q;

	public Meat(int quality) {
		super("Meat", quality);
		this.Q = quality;
		this.exp = 2;
	}

	public String getType() {
		String s;
		if (Q == 0) {
			s = "low";
		} else if (Q == 1) {
			s = "Medium";
		} else {
			s = "Luxury";
		}
		return s;
	}

	public int daypassed() {

		return exp--;
	}

	public int getExp() {
		return exp;

	}

	public int setExp(int level) {

		return exp + level;
	}

	public String toString() {

		return "Meat" + String.valueOf(Q);
	}

}
