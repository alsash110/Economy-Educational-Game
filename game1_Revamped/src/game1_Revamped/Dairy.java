package game1_Revamped;

public class Dairy extends items {

	private int exp = 1;

	public Dairy(int quality) {
		super("Dairy", quality);
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getExp() {

		return exp;
	}

	public int setExp(int level) {

		return exp + level;
	}

	public int daypassed() {
		return exp--;

	}

}
