public abstract class Shape implements Comparable<Shape>, Cloneable, Scalable{
    private String color;

    protected Shape(){
        color = "none";
    }
    protected Shape(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String toString(){
        return String.format("%-10s", color);
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public int compareTo(Shape shape){
        if(this.getArea() == shape.getArea()){
            return 0;
        }
        else if(this.getArea() > shape.getArea()){
            return 1;
        }
        else{
            return -1;
        }
    }
    public abstract Object clone();
    public abstract void scale(double factor);
}