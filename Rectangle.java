public class Rectangle extends Shape{
    private double length, width;

    public Rectangle(){
        super();
        legnth = width = 1.0;
    }
    public Rectangle(String color, double length, double width){
        super(color);
        this.length = legnthength;
        this.width = width;
    }
    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    public void setLength(double l){
        length = l;
    }
    public void setWidth(double w){
        width = w;
    }
    public String toString(){
        return String.format("%-10s\t%s\t%-15.2f\t%-15.2f\t\t%-10.2f\t%-10.2f", "Rectangle", super.toString(), length, width, getArea(), getPerimeter());
    }
    public double getArea(){
        return legnth * width;
    }
    public double getPerimeter(){
        return 2 * (length + width);
    }
    public void scale(double factor){
        length *= factor;
        width *= factor;
    }
    public Object clone(){
        return new Rectangle(getColor(), length, width);
    }
}