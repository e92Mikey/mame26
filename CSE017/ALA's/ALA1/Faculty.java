public class Faculty extends Employee{
    private String rank;

    public Faculty(){
        super();
        rank = "Assistant Professor";
    }
    public Faculty(int id, String n, String a, String ph, String e, String po, double s, String r){
        super(id, n, a, ph, e, po, s);
        rank = r;
    }
    public String getRank() { return rank;}
    public void setRank(String r) { rank = r;}
    public String toString(){
        return super.toString() + "Rank: " + rank + "\n";
    }
}