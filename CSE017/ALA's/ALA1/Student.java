public class Student extends Person{
    private String major;

    public Student(){
        super();
        major = "Undeclared";
    }
    public Student(int id, String n, String a, String p, String e, String m){
        super(id, n, a, p, e);
        major = m;
    }
    public String getMajor(){ return major;}
    public void setMajor(String m) { major = m;}

    public String toString(){
        return super.toString() + "\nMajor: " + major + "\n";
    }
}