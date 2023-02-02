public class Rectangle implements Shape{
    private double width;
    private double length;

    public Rectangle(){
    }

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public double getWidth(){
        return width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public double getLength(){
        return length;
    }

    public void setLength(double length){
        this.length = length;
    }

    public String toString(){
        return "Rectangle[width=" + width + ", length=" + length + "]";
    }

    public double getArea(){
        return width * length;
    }
}