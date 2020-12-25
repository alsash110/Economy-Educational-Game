package game1_Revamped;

import java.util.ArrayList;

public class Warehouse extends Upgradable {

	private ArrayList<Meat> numMeat = new ArrayList<Meat>();
	private ArrayList<Meat> numMeatM = new ArrayList<Meat>();
	private ArrayList<Meat> numMeatL = new ArrayList<Meat>();

	private ArrayList<Dairy> numDairy = new ArrayList<Dairy>();
	private ArrayList<Dairy> numDairyM = new ArrayList<Dairy>();
	private ArrayList<Dairy> numDairyL = new ArrayList<Dairy>();

	private ArrayList<Clothe> numClothe = new ArrayList<Clothe>();
	private ArrayList<Clothe> numClotheM = new ArrayList<Clothe>();
	private ArrayList<Clothe> numClotheL = new ArrayList<Clothe>();

	private int level = 0;

	@Override
	public int upgrade() {

		return level++;
	}

	public ArrayList getnumMeat(int quality) {

		if (quality == 0) {
			return numMeat;
		} else if (quality == 1) {
			return numMeatM;
		} else {
			return numMeatL;
		}
	}

	public ArrayList addMeat(items i) {
		if (i.Q == 0) {
			((Meat) i).setExp(level);
			numMeat.add((Meat) i);
			return numMeat;
		} else if (i.Q == 1) {
			((Meat) i).setExp(level);
			numMeatM.add((Meat) i);
			return numMeatM;
		} else {
			((Meat) i).setExp(level);
			numMeatL.add((Meat) i);
			return numMeatL;
		}
	}

	public ArrayList addClothe(items i) {

		if (i.Q == 0) {
			numClothe.add((Clothe) i);
			return numClothe;
		} else if (i.Q == 1) {
			numClotheM.add((Clothe) i);
			return numClotheM;
		} else {
			numClotheL.add((Clothe) i);
			return numClotheL;
		}
	}

	public ArrayList addDairy(items i) {
		if (i.Q == 0) {
			((Dairy) i).setExp(level);
			numDairy.add((Dairy) i);
			return numDairy;
		} else if (i.Q == 1) {
			((Dairy) i).setExp(level);
			numDairyM.add((Dairy) i);
			return numDairyM;
		} else {
			((Dairy) i).setExp(level);
			numDairyL.add((Dairy) i);
			return numDairyL;
		}
	}

	public int addExp() {

		return 1 + level;
	}

	public ArrayList expired( items i){
		if(i.T.equals("Meat") && i.Q == 0){
			numMeat.remove(i);
			return numMeat;
		}else if(i.T.equals("Meat") && i.Q == 1){
			numMeatM.remove(i);
			return numMeatM;
		}else if(i.T.equals("Meat") && i.Q == 2){
			numMeatL.remove(i);
			return numMeatL;
		}else if(i.T.equals("Dairy") && i.Q == 0){
			numDairy.remove(i);
			return numDairy;
		}else if(i.T.equals("Dairy") && i.Q == 1){
			numDairyM.remove(i);
			return numDairyM;
		}else{
			numDairyL.remove(i);
			return numDairyL;
		}
		
		
	}
	
	public ArrayList getnumClothe(int quality) {
		if (quality == 0) {
			return numClothe;
		} else if (quality == 1) {
			return numClotheM;
		} else {
			return numClotheL;
		}

	}

	public ArrayList getnumDairy(int quality) {
		if (quality == 0) {
			return numDairy;
		} else if (quality == 1) {
			return numDairyM;
		} else {
			return numDairyL;
		}

	}
	public int getLevel(){ return level;}

}
