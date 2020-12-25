package game1_Revamped;

import java.util.Random;

public class Customer {

	private int  typeB, type;// # of items buying & #of types buying
	Random r = new Random();

	public Customer() {
		this.type = gettype();
		
	}


	public int gettype() {
		int n = r.nextInt(10);
		if (n < 6) {

			return 0;
		} else if (n < 9) {
			return 1;

		} else {

			return 2;
		}

	}

	public String gettypeB() {
		int x = r.nextInt(3) + 1;
		String s = "";
		switch (x) {
		case 1:
			s = "Meat";
			break;
		case 2:
			s = "Dairy";
			break;
		case 3:
			s = "Clothing";
			break;
		}

		return s;
	}

}
