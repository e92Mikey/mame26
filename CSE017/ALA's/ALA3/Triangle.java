public class Triangle extends Shape{
    private double side1, side2, side3;

    public Triangle(){
        super();
        side1 = side2 = side3 = 1.0
    }
    public Triangle(String color, double s1, double s2, double s3){
        super(color);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }
    public double getSide1(){ return side1;}
    public double getSide2(){ return side2;}
    public double getSide3(){ return side3;}

    public void setSide1(double s) {side1 = s;}
    public void setSide2(double s) {side2 = s;}
    public void setSide3(double s) {side3 = s;}

    public String toString(){
        return String.format("%-10\t%s\t%10.2f\t%10.2f\t%10.2f\t%10.2f\t%10.2f", "Triangle", super.toString(), side1, side2, side3, getArea(), getPerimeter());
    }
    public double getArea(){
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p-side1) * (p-side2) * (p-side3));
    }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    public void scale(double factor){
        side1 *= factor;
        side2 *= factor;
        side3 *= factor;
    }
    public Object clone(){
        return new Triangle(getColor(), side1, side2, side3);

    }
}
