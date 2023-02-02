public class Triangle{
    private double base;
    private double height;

    public Triangle(){
    }

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    public double getBase(){
        return base;
    }

    public void setBase(double base){
        this.base = base;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public String toString(){
        return "Triangle[base=" + base + ", height=" + height + "]";
    }

    public double getArea(){
        return base * height / 2;
    }
}