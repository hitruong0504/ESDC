public class Square extends Rectangle{
    public Square(){
    }

    public Square(double side){
        super(side, side);
    }

    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }

    public double getSide(){
        return width;
    }

    public void setSide(double side){
        width = side;
        length = side;
    }

    public void setWidth(double side){
        width = side;
        length = side;
    }

    public void setLength(double side){
        width = side;
        length = side;
    }

    public String toString(){
        return "Square[side=" + width + ", color=" + color + ", filled=" + filled + "]";
    }
}