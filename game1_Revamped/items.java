package game1_Revamped;

public abstract class items {

    public int Q;
    public String T;
    //abstract class items super constructor

    public items(String type, int quality) {

        this.T = type;
        this.Q = quality;

    }
    //gets type

    public String getType() {

        return T;
    }
    //gets quality

    public String getQuality() {
        String s = "";
        if (Q == 0) {
            s = "low";
        } else if (Q == 1) {
            s = "Medium";
        } else {
            s = "Luxury";
        }
        return s;
    }

}
