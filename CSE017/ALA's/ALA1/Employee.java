public class Employee extends Person{
    private String position;
    private double salary;

    public Employee(){
        super();
        position = "none";
        salary = 0.0;
    }
    public Employee(int id, String n, String a, String p, String e, String po, double s){
        super(id, n, a, p, e);
        position = po;
        salary = s;
    }
    public String getPosition(){ return position; }
    public double getSalary(){ return salary;}

    public void setPosition(String p) { position = p;}
    public void setSalary(double s){salary = s;}
    public String toString(){
        return super.toString() + String.format("Position: %s\nAnnual Salary: $%.2f\n", position, salary);
    }   
}    