class Test{
    public static void main(String args[]){
        Rectangle r1 = new Rectangle();
        System.out.println("Length is " + r1.getLength());
        System.out.println("Width is " + r1.getWidth());
        System.out.println("Area is " + r1.getArea());
        System.out.println("Perimeter is " + r1.getPerimeter());
        System.out.println(r1.toString());
        Rectangle r2 = new Rectangle(2.0f, 4.0f);
        System.out.println("Length is " + r2.getLength());
        System.out.println("Width is " + r2.getWidth());
        System.out.println("Area is " + r2.getArea());
        System.out.println("Perimeter is " + r2.getPerimeter());
        System.out.println(r2.toString());
    }
}