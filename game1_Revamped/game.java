package game1_Revamped;
//imports

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import net.miginfocom.swing.MigLayout;

public class game extends JPanel {

    // variables, earned: revenue for the day, budget: amount of money in your possession, day: the day, rep: reputation value
    private double budget = 200.00, earned;
    public int day = 0, rep = 0;
    //RNG
    Random r = new Random();
    //objects 
    private Warehouse w = new Warehouse();
    private Store store = new Store();
    private items m;
    private Customer c;
    private BufferedImage i;

    public static void main(String[] args) {
        // JFrame settings, size, not resiazable, visible and adds JPanel(game) to JFrame
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

        // JPanel Layout Manager: MigLayout, an useful layout manager. *GridBoxLayout is for masochists*
        // Note: Needs MiG External Library to run
        //Mig row and column space margins 
        MigLayout mig = new MigLayout("", "15[]15[]25[]10[]40[]160[]160[]60[]60[]",
                "[]60[]30[]10[]10[]60[]10[]10[]60[]10[]10[]60[]10[]10[]");
        //adding Mig to Jpanl & setting Backround to GREEN
        setLayout(mig);

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

        // Text field for cheap meats, gets # of cheap meat from Warehouse
        JTextField f = new JTextField(String.valueOf(w.getnumMeat(0).size()));
        f.setEditable(false);
        f.setFont(font);
        add(f, "span 2, growx");

        //Items buttons/TextAreas/Labels until line 325
        // Button for cheap meats
        JButton b = new JButton("add 1");
        add(b);
        //action Listener inside another method. Makes life a lot easier
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //updates labels & buttons
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
        JScrollPane sp = new JScrollPane();
        add(sp, "span 4 9, grow,wrap");
        //TextBox in the center, kinda regret not using JOptionpane for colored text
        JTextArea text = new JTextArea();
        text.setFont(font);
        text.setEditable(false);
        sp.add(text);
        sp.setViewportView(text);

        sp.setPreferredSize(sp.getMaximumSize());
        //Auto scroll
        DefaultCaret caret = (DefaultCaret) text.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

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
        // Label for luxury clothes
        JLabel llc = new JLabel("Lux Clothes, costs $44");
        llc.setFont(font);
        add(llc);

        // Text field for luxury clothes *fieldLuxuryClothe --> flc
        JTextField flc = new JTextField(String.valueOf(w.getnumClothe(2).size()));
        flc.setEditable(false);
        flc.setFont(font);
        add(flc, "span 2, growx");

        // Button for Luxury clothes
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

        // Day:  label
        JLabel days = new JLabel("Day: " + String.valueOf(day));
        days.setFont(font);
        add(days, "cell 7 0 1 1");

        // Upgrades
        // Warehouse label
        JLabel curW = new JLabel("Current Warehouse: +" + w.getLevel() + " exp day");
        curW.setFont(font);
        add(curW, "cell 8 2 1 1");
        //another label
        JLabel upW = new JLabel("Price: $" + w.getCost(w.getLevel() + 1));
        upW.setFont(font);
        add(upW, "cell 8 3 1 1");
        //Upgrade buttton, using "absolute positioning(setLayout(null))" with MiG
        JButton up = new JButton("Upgrade Warehouse");
        add(up, "cell 8 4 1 1");
        up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (budget >= w.getCost(w.getLevel() + 1)) {
                    //if budget is large enough
                    budget -= w.getCost(w.getLevel() + 1);
                    //upgrade, warehouse method
                    w.upgrade();
                    //update labels
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
        //other label
        JLabel upS = new JLabel("Price: $" + store.getCost(store.getLevel() + 1));
        upS.setFont(font);
        add(upS, "cell 8 7 1 1");
        //upgrade button, store version
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
                if (day < 15) {
                    //sets text to blue. One time only becasue textArea isn't meant for colors
                    text.setForeground(Color.BLUE);
                    //random for # of customers; random from 2 to limit.
                    int ran = r.nextInt(store.getLimit() - 2) + (2);
                    //if reputation + the RNG # of customers is less than the limit, add the rep # to the RNG.
                    if (rep + ran < store.getLimit() && rep + ran >= 0) {
                        ran += rep;
                    } else if (rep + ran < 0) {
                        //if reputaton is below 0, check if rep + ran will result in negative customers. If so, set ran to 0
                        ran = 0;
                    } else {
                        //else, set the number to the limit.
                        ran = store.getLimit();
                    }
                    // Getting the budget value before the day starts
                    earned = budget;
                    //looping through ,creating customers
                    for (int i = 0; i < ran; i++) {
                        c = new Customer();
                        text.append("A new customer has arrived\n");
                        //bought method
                        bought(c, text, c.gettypeB());

                        text.append("The customer has left\n");

                    }
                    //Expiration date loops
                    int[] x = new int[6];
                    for (int v = 0; v < 6; v++) {
                        if (v < 3) {
                            for (int i = 0; i < w.getnumMeat(v).size(); i++) {
                                ((Meat) w.getnumMeat(v).get(i)).daypassed();
                                if (((Meat) w.getnumMeat(v).get(i)).getExp() == 0) {
                                    w.expired((Meat) w.getnumMeat(v).get(i));
                                    x[v]++;
                                    i--;
                                }
                            }
                        } else {
                            for (int i = 0; i < w.getnumDairy(v - 3).size(); i++) {
                                ((Dairy) w.getnumDairy(v - 3).get(i)).daypassed();
                                if (((Dairy) w.getnumDairy(v - 3).get(i)).getExp() == 0) {
                                    w.expired((Dairy) w.getnumDairy(v - 3).get(i));
                                    x[v]++;
                                    i--;
                                }
                            }
                        }

                    }
                    //cou;d've shortened it down to 2 cases with another set of getters but this is just easier
                    for (int i = 0; i < 6; i++) {
                        switch (i) {
                            case 0:
                                if (x[i] > 0) {
                                    text.append(x[i] + " cheap meat has expired\n");
                                }
                                break;
                            case 1:
                                if (x[i] > 0) {
                                    text.append(x[i] + " medium meat has expired\n");
                                }
                                break;
                            case 2:
                                if (x[i] > 0) {
                                    text.append(x[i] + " luxury meat has expired\n");
                                }
                                break;

                            case 3:
                                if (x[i] > 0) {
                                    text.append(x[i] + " cheap dairy has expired\n");
                                }
                                break;
                            case 4:
                                if (x[i] > 0) {
                                    text.append(x[i] + " medium dairy has expired\n");
                                }
                                break;
                            case 5:
                                if (x[i] > 0) {
                                    text.append(x[i] + " luxury dairy has expired\n");
                                }
                                break;
                        }
                    }

                    //Day end text & label/textarea updates
                    text.append(ran + " customers shopped today\n");
                    bu.setText("Budget: $" + String.valueOf(getBudget()));
                    earned = budget - earned;
                    reputation.setText("Repuatation: " + String.valueOf(rep));
                    text.append("Total Revenue Earned:" + earned + "\n");
                    day++;
                    days.setText("Day: " + day);

                    text.append("----------------- \n");

                    //meat text updates
                    f.setText(String.valueOf(w.getnumMeat(0).size()));
                    fl.setText(String.valueOf(w.getnumMeat(2).size()));
                    fm.setText(String.valueOf(w.getnumMeat(1).size()));
                    //dairy text updates
                    fd.setText(String.valueOf(w.getnumDairy(0).size()));
                    fld.setText(String.valueOf(w.getnumDairy(2).size()));
                    fmd.setText(String.valueOf(w.getnumDairy(1).size()));
                    //cloth textarea updates
                    fc.setText(String.valueOf(w.getnumClothe(0).size()));
                    flc.setText(String.valueOf(w.getnumClothe(2).size()));
                    fmc.setText(String.valueOf(w.getnumClothe(1).size()));
                } else {
                    JOptionPane.showMessageDialog(null, "In 15 days, you have made a total of: " + budget);
                }
            }
        });

    }
//text stuff + remove meat

    public ArrayList bought(Customer c, JTextArea j, String type) {
        if (type.equals("Meat")) {
            switch (c.gettype()) {
                case 0:

                    if (w.getnumMeat(0).size() >= 1) {
                        w.getnumMeat(0).remove(0);
                        addBudget(12 + (rep * .50));
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
                        addBudget(23 + (rep * .50));
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
                        addBudget(35 + (rep * .50));
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
                        addBudget(12 + (rep * .50));
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
                        addBudget(23 + (rep * .50));
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
                        addBudget(35 + (rep * .50));
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
                        addBudget(12 + (rep * .50));
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
                        addBudget(23 + (rep * .50));
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
                        addBudget(35 + (rep * .50));
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

        //Pointless, unreachable return statement
        return w.getnumClothe(0);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // File f = new File("C:\\Users\\yiran\\Documents\\game1_Revamped\\src");
        try {
            i = ImageIO.read(new File("H:\\Pictures\\New Folder\\pic.png")); // change based on where your pic.png is
        } catch (IOException ex) {
            Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
        }

        g.drawImage(i, 0, 0, 1200, 800, null);

    }

    public double getBudget() {
        return budget;

    }

    public double addBudget(double n) {
        budget += n;
        return budget;

    }

}
