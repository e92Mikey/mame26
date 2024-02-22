public class Circle extends Shape{
    private double radius;

    public Circle(){
        super();
        radius = 1.0;
    }
    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public String toString(){
        return String.format("%-10s\t%s\t%-30.2f\t\t%-10.2f\t%-10.2f", "Circle", super.toString(), radius, getArea(), getPerimeter());
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    public void scale(double factor){
        radius = radius * factor;
    }
    public Object clone(){
        return new Circle(getColor(), radius);
    }
}