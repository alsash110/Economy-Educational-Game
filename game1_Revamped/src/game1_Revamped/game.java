package game1_Revamped;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import net.miginfocom.swing.MigLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 754479
 */
public class game extends JPanel {

	// Lists of items
	/*
	 * private ArrayList<Meat> numMeat = new ArrayList<Meat>(); private
	 * ArrayList<Meat> numMeatM = new ArrayList<Meat>(); private ArrayList<Meat>
	 * numMeatL = new ArrayList<Meat>();
	 * 
	 * private ArrayList<Dairy> numDairy = new ArrayList<Dairy>(); private
	 * ArrayList<Dairy> numDairyM = new ArrayList<Dairy>(); private
	 * ArrayList<Dairy> numDairyL = new ArrayList<Dairy>();
	 * 
	 * private ArrayList<Clothe> numClothe = new ArrayList<Clothe>(); private
	 * ArrayList<Clothe> numClotheM = new ArrayList<Clothe>(); private
	 * ArrayList<Clothe> numClotheL = new ArrayList<Clothe>();
	 */

	private int budget = 200, earned;
	private int day = 0, rep = 0;
	Random r = new Random();
	Warehouse w = new Warehouse();
	Store store = new Store();
	items m;
	Customer c;

	public static void main(String[] args) {
		// JFrame settings
		game t = new game();
		JFrame s = new JFrame();
		s.setSize(1200, 800);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
		s.setResizable(false);
		s.setLocationRelativeTo(null);
		s.add(t);
	}

	public game() {

		// Setting JPanel Layout using MigLayout *GridBoxLayout is torture*
		// Note: Needs MiG Library to run
		MigLayout mig = new MigLayout("", "15[]15[]25[]10[]40[]160[]160[]60[]60[]",
				"[]60[]30[]10[]10[]60[]10[]10[]60[]10[]10[]60[]10[]10[]");
		setLayout(mig);
		setBackground(Color.GREEN);

		// Fonts
		Font font = new Font("Ariel", Font.PLAIN, 18);
		Font titles = new Font("Bold", Font.BOLD, 36);
		Font Bigger = new Font("Big", Font.ROMAN_BASELINE, 24);

		// Budget sign

		JLabel bu = new JLabel("Budget: $" + String.valueOf(budget));
		bu.setFont(font);
		add(bu, "span 5");

		// Store label
		JLabel name = new JLabel("Store");
		name.setFont(titles);
		add(name, "span 3, growx");

		// rep label
		JLabel reputation = new JLabel("Repuatation: " + String.valueOf(rep));
		reputation.setFont(font);
		add(reputation, "wrap");

		// Buy stock label
		JLabel buy = new JLabel("Buy Stock");
		buy.setFont(Bigger);
		add(buy, "wrap");

		// Label for cheap meats
		JLabel l = new JLabel("Cheap Meat, costs $10");
		l.setFont(font);
		add(l);

		// Text field for cheap meats
		JTextField f = new JTextField(String.valueOf(w.getnumMeat(0).size()));
		f.setEditable(false);
		f.setFont(font);
		add(f, "span 2, growx");

		// Button for cheap meats
		JButton b = new JButton("add 1");
		add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= 10) {
					m = new Meat(0);
					w.addMeat(m);
					budget -= 10;
					f.setText(String.valueOf(w.getnumMeat(0).size()));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});
		// Text Box + scroll
		ScrollPane sp = new ScrollPane();
		add(sp, "span 4 9, grow,wrap");

		JTextArea text = new JTextArea();
		sp.add(text);
		DefaultCaret caret = (DefaultCaret) text.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		text.setFont(font);
		text.setEditable(false);

		// Label for Medium meats
		JLabel lm = new JLabel("Med Meat, Costs $20");
		lm.setFont(font);
		add(lm);

		// Text field for med meats
		JTextField fm = new JTextField(String.valueOf(w.getnumMeat(1).size()));
		fm.setEditable(false);
		fm.setFont(font);
		add(fm, "span 2, grow");

		// Button for med meats
		JButton bm = new JButton("add 1");
		add(bm, "wrap");
		bm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= 20) {
					m = new Meat(1);
					w.addMeat(m);
					budget -= 20;
					fm.setText(String.valueOf(w.getnumMeat(1).size()));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});
		// Label for luxury meats
		JLabel ll = new JLabel("Lux meat, costs $30");
		ll.setFont(font);
		add(ll);

		// Text field for luxury meats
		JTextField fl = new JTextField(String.valueOf(w.getnumMeat(2).size()));
		fl.setEditable(false);
		fl.setFont(font);
		add(fl, "span 2, growx");

		// Button for Luxury meats
		JButton bl = new JButton("add 1");
		add(bl, "wrap");
		bl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= 30) {
					m = new Meat(2);
					w.addMeat(m);
					budget -= 30;
					fl.setText(String.valueOf(w.getnumMeat(2).size()));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});
		// DAIRY
		// Label for cheap dairy
		JLabel d = new JLabel("Cheap Dairy, costs $8 ");
		d.setFont(font);
		add(d);

		// Text field for cheap dairy
		JTextField fd = new JTextField(String.valueOf(w.getnumDairy(0).size()));
		fd.setEditable(false);
		fd.setFont(font);
		add(fd, "span 2, growx");

		// Button for cheap dairy
		JButton bd = new JButton("add 1");
		add(bd, "wrap");
		bd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= 8) {
					m = new Dairy(0);
					w.addDairy(m);
					budget -= 8;
					fd.setText(String.valueOf(w.getnumDairy(0).size()));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});
		// Label for Medium Dairy
		JLabel lmd = new JLabel("Med Dairy, costs $18");
		lmd.setFont(font);
		add(lmd);

		// Text field for med dairy
		JTextField fmd = new JTextField(String.valueOf(w.getnumDairy(1).size()));
		fmd.setEditable(false);
		fmd.setFont(font);
		add(fmd, "span 2, growx");

		// Button for med dairy
		JButton bmd = new JButton("add 1");
		add(bmd, "wrap");
		bmd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= 18) {
					m = new Dairy(1);
					w.addDairy(m);
					budget -= 18;
					fmd.setText(String.valueOf(w.getnumDairy(1).size()));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});
		// Label for luxury dairy
		JLabel lld = new JLabel("Lux Dairy, costs $27");
		lld.setFont(font);
		add(lld);

		// Text field for luxury dairy
		JTextField fld = new JTextField(String.valueOf(w.getnumDairy(2).size()));
		fld.setEditable(false);
		fld.setFont(font);
		add(fld, "span 2, growx");

		// Button for Luxury dairy
		JButton bld = new JButton("add 1");
		add(bld, "wrap");
		bld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= 27) {
					m = new Dairy(2);
					w.addDairy(m);
					budget -= 27;
					fld.setText(String.valueOf(w.getnumDairy(2).size()));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});

		// Clothing

		// DAIRY
		// Label for cheap dairy
		JLabel cl = new JLabel("Cheap Clothes, costs $16");
		cl.setFont(font);
		add(cl);

		// Text field for cheap dairy
		JTextField fc = new JTextField(String.valueOf(w.getnumClothe(0).size()));
		fc.setEditable(false);
		fc.setFont(font);
		add(fc, "span 2, growx");

		// Button for cheap dairy
		JButton bc = new JButton("add 1");
		add(bc, "wrap");
		bc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= 16) {
					m = new Clothe(0);
					w.addClothe(m);
					budget -= 16;
					fc.setText(String.valueOf(w.getnumClothe(0).size()));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});
		// Label for Medium Clothes
		JLabel lmc = new JLabel("Medium Clothes, costs $30");
		lmc.setFont(font);
		add(lmc);

		// Text field for med Clothes
		JTextField fmc = new JTextField(String.valueOf(w.getnumClothe(1).size()));
		fmc.setEditable(false);
		fmc.setFont(font);
		add(fmc, "span 2, growx");

		// Button for med clothes
		JButton bmc = new JButton("add 1");
		add(bmc, "wrap");
		bmc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= 30) {
					m = new Clothe(1);
					w.addClothe(m);
					budget -= 30;
					fmc.setText(String.valueOf(w.getnumClothe(1).size()));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});
		// Label for luxury clothe
		JLabel llc = new JLabel("Lux Clothes, costs $44");
		llc.setFont(font);
		add(llc);

		// Text field for luxury clothes *fieldLuxuryClothe --> flc
		JTextField flc = new JTextField(String.valueOf(w.getnumClothe(2).size()));
		flc.setEditable(false);
		flc.setFont(font);
		add(flc, "span 2, growx");

		// Button for Luxury clothe
		JButton blc = new JButton("add 1");
		add(blc, "wrap");
		blc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= 44) {
					m = new Clothe(2);
					w.addClothe(m);
					budget -= 44;
					flc.setText(String.valueOf(w.getnumClothe(2).size()));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});

		// day label
		JLabel days = new JLabel("Day: " + String.valueOf(day));
		days.setFont(font);
		add(days, "cell 7 0 1 1");

		// Upgrade stuffs
		// Warehouse
		JLabel curW = new JLabel("Current Warehouse: +" + w.getLevel() + " exp day");
		curW.setFont(font);
		add(curW, "cell 8 2 1 1");
		JLabel upW = new JLabel("Price: $" + w.getCost(w.getLevel() + 1));
		upW.setFont(font);
		add(upW, "cell 8 3 1 1");
		JButton up = new JButton("Upgrade Warehouse");
		add(up, "cell 8 4 1 1");
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= w.getCost(w.getLevel() + 1)) {
					budget -= w.getCost(w.getLevel() + 1);
					w.upgrade();
					curW.setText("Current Warehouse: +" + w.getLevel() + " exp day");
					upW.setText("Price: $" + w.getCost(w.getLevel() + 1));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});
		// store
		JLabel curS = new JLabel("Store limit: " + store.getLimit() + " people");
		curS.setFont(font);
		add(curS, "cell 8 6 1 1");
		JLabel upS = new JLabel("Price: $" + store.getCost(store.getLevel() + 1));
		upS.setFont(font);
		add(upS, "cell 8 7 1 1");
		JButton upB = new JButton("Upgrade Store");
		add(upB, "cell 8 8 1 1");
		upB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (budget >= store.getCost(store.getLevel() + 1)) {
					budget -= store.getCost(store.getLevel() + 1);
					store.upgrade();
					curS.setText("Store limit: " + store.getLimit() + " people");
					upS.setText("Price: $" + store.getCost(store.getLevel() + 1));
					bu.setText("Budget: $" + String.valueOf(budget));
				}
			}
		});
		// start button

		JButton start = new JButton("Start day");
		add(start, "cell 5 12 2 2 , grow");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				text.setForeground(Color.BLUE);
				int ran = r.nextInt(store.getLimit() - 2) + (2) + 1 * (rep);
				earned = budget;
				for (int i = 0; i < ran; i++) {
					c = new Customer();
					text.append("A new customer has arrived\n");
					bought(c, text, c.gettypeB());

					text.append("The customer has left\n");

				}
				int x = 0, x1 = 0, x2 = 0, x3 = 0, d = 0, d1 = 0, d2 = 0;
				for (int i = 0; i < w.getnumMeat(0).size(); i++) {
					((Meat) w.getnumMeat(0).get(i)).daypassed();
					if (((Meat) w.getnumMeat(0).get(i)).getExp() == 0) {
						w.expired((Meat) w.getnumMeat(0).get(i));
						x++;
						i--;
					}
				}

				for (int i = 0; i < w.getnumMeat(1).size(); i++) {
					((Meat) w.getnumMeat(1).get(i)).daypassed();
					if (((Meat) w.getnumMeat(1).get(i)).getExp() == 0) {
						w.expired((Meat) w.getnumMeat(1).get(i));
						x2++;
						i--;
					}
				}
				for (int i = 0; i < w.getnumMeat(2).size(); i++) {
					((Meat) w.getnumMeat(2).get(i)).daypassed();
					if (((Meat) w.getnumMeat(2).get(i)).getExp() == 0) {
						w.expired((Meat) w.getnumMeat(2).get(i));
						x2++;
						i--;
					}
				}
				for (int i = 0; i < w.getnumDairy(0).size(); i++) {
					((Dairy) w.getnumDairy(0).get(i)).daypassed();
					if (((Dairy) w.getnumDairy(0).get(i)).getExp() == 0) {
						w.expired((Dairy) w.getnumDairy(0).get(i));
						d++;
						i--;
					}
				}
				for (int i = 0; i < w.getnumDairy(1).size(); i++) {
					((Dairy) w.getnumDairy(1).get(i)).daypassed();
					if (((Dairy) w.getnumDairy(1).get(i)).getExp() == 0) {
						w.expired((Dairy) w.getnumDairy(1).get(i));
						d1++;
						i--;
					}
				}
				for (int i = 0; i < w.getnumDairy(2).size(); i++) {
					((Dairy) w.getnumDairy(2).get(i)).daypassed();
					if (((Dairy) w.getnumDairy(2).get(i)).getExp() == 0) {
						w.expired((Dairy) w.getnumDairy(2).get(i));
						d2++;
						i--;
					}
				}
				if(x > 0){text.append(x + " cheap meat has expired\n");}
				if(x1 > 0){text.append(x1 + " medium meat has expired\n");}
				if(x2 > 0){text.append(x2 + " luxury meat has expired\n");}
				if(d > 0){text.append(d + " cheap dairy has expired\n");}
				if(d1 > 0){text.append(d1 + " medium dairy has expired\n");}
				if(d2 > 0){text.append(d2 + " luxury dairy has expired\n");}
				
				text.append(ran + " customers shopped today\n");
				bu.setText("Budget: $" + String.valueOf(getBudget()));
				earned = budget - earned;
				reputation.setText("Repuatation: " + String.valueOf(rep));
				text.append("Total Revenue Earned:" + earned + "\n");
				day++;
				days.setText("Day: " + day);

				f.setText(String.valueOf(w.getnumMeat(0).size()));
				fl.setText(String.valueOf(w.getnumMeat(2).size()));
				fm.setText(String.valueOf(w.getnumMeat(1).size()));

				fd.setText(String.valueOf(w.getnumDairy(0).size()));
				fld.setText(String.valueOf(w.getnumDairy(2).size()));
				fmd.setText(String.valueOf(w.getnumDairy(1).size()));

				fc.setText(String.valueOf(w.getnumClothe(0).size()));
				flc.setText(String.valueOf(w.getnumClothe(2).size()));
				fmc.setText(String.valueOf(w.getnumClothe(1).size()));
			}

		});

	}

	public ArrayList bought(Customer c, JTextArea j, String type) {
		if (type.equals("Meat")) {
			switch (c.gettype()) {
			case 0:

				if (w.getnumMeat(0).size() >= 1) {
					w.getnumMeat(0).remove(0);
					addBudget(12);
					rep += 1 * store.getLevel();

					j.append("A cheap meat has been bought.\n");

					return w.getnumMeat(0);
				} else {
					j.append("A customer tried to buy cheap meat but none was left...\n");
					rep--;
				}
				break;
			case 1:

				if (w.getnumMeat(1).size() >= 1) {
					w.getnumMeat(1).remove(0);
					addBudget(23);
					rep += 1 * store.getLevel();

					j.append("A medium meat has been bought.\n");
					return w.getnumMeat(1);
				} else {
					j.append("A customer tried to buy medium meat but none was left...\n");
					rep--;
				}
				break;
			case 2:
				System.out.println("hi");
				if (w.getnumMeat(2).size() >= 1) {
					w.getnumMeat(2).remove(0);
					addBudget(35);
					rep += 1 * store.getLevel();
					j.append("A luxury meat has been bought.\n");

					return w.getnumMeat(2);
				} else {
					j.append("A customer tried to buy luxury meat but none was left...\n");
					rep--;
				}
				break;

			}
		} else if (type.equals("Dairy")) {
			switch (c.gettype()) {
			case 0:
				if (w.getnumDairy(0).size() >= 1) {
					w.getnumDairy(0).remove(0);
					addBudget(12);
					rep += 1 * store.getLevel();

					j.append("A cheap dairy has been bought.\n");
					return w.getnumDairy(0);
				} else {
					j.append("A customer tried to buy cheap dairy but none was left...\n");
					rep--;
				}
				break;
			case 1:
				if (w.getnumDairy(1).size() >= 1) {
					w.getnumDairy(1).remove(0);
					addBudget(23);
					rep += 1 * store.getLevel();

					j.append("A medium dairy has been bought.\n");
					return w.getnumDairy(1);
				} else {
					j.append("A customer tried to buy medium dairy but none was left...\n");
					rep--;
				}
				break;
			case 2:
				if (w.getnumDairy(2).size() >= 1) {
					w.getnumDairy(2).remove(0);
					addBudget(35);
					rep += 1 * store.getLevel();
					j.append("A luxury dairy has been bought.\n");
					return w.getnumDairy(2);
				} else {
					j.append("A customer tried to buy luxury dairy but none was left...\n");
					rep--;
				}
				break;
			}

		} else {
			switch (c.gettype()) {
			case 0:
				if (w.getnumClothe(0).size() >= 1) {
					w.getnumClothe(0).remove(0);
					addBudget(12);
					rep += 1 * store.getLevel();

					j.append("A cheap " + c.gettypeB() + " has been bought.\n");
					return w.getnumClothe(0);
				} else {
					j.append("A customer tried to buy cheap clothe but none was left...\n");
					rep--;
				}
				break;
			case 1:
				if (w.getnumClothe(1).size() >= 1) {
					w.getnumClothe(1).remove(0);
					addBudget(23);
					rep += 1 * store.getLevel();

					j.append("A medium " + c.gettypeB() + " has been bought.\n");
					return w.getnumClothe(1);
				} else {
					j.append("A customer tried to buy medium clothe but none was left...\n");
					rep--;
				}
				break;
			case 2:
				if (w.getnumClothe(2).size() >= 1) {
					w.getnumClothe(2).remove(0);
					addBudget(35);
					rep += 1 * store.getLevel();
					j.append("A luxury " + c.gettypeB() + " has been bought.\n");
					return w.getnumClothe(2);
				} else {
					j.append("A customer tried to buy luxury clothe but none was left...\n");
					rep--;
				}
				break;
			}

		}
		// end

		return w.getnumClothe(0);

	}

	public int getBudget() {
		return budget;

	}

	public int addBudget(int n) {
		budget += n;
		return budget;

	}

	public int subBudget(int n) {
		budget -= n;
		return budget;

	}

}