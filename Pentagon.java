public class Pentagon extends Shape{
    private double side;
    public Pentagon(){
        super();
        side = 1.0;
    }
    public Pentagon(String color, double side){
        super(color);
        this.side = side;
    }
    public double getSide(double side){ this.side = side;}

    public String toString(){
        return String.format("%-10s\t%s\t%-30.2f\t%-10.2f\t%-10.2f", "Pentagon", super.toString(), side, getArea(), getPerimeter());
    }
    public double getArea(){
        double a = 1/4.0 * Math.sqrt(5 * (5+2*Math.sqrt(5)));
        a *= side * side;
        return a;
    }
    public double getPerimeter(){
        return side * 5;
    }
    public void scale(double factor){
        side *= factor;
    }
    public Object clone(){
        return new Pentagon(getColor(), side); 
    }
}