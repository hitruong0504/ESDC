class Test{
    public static void main(String args[]){
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(10, 8);
        Triangle t1 = new Triangle(5, 5);
        Triangle t2 = new Triangle(7, 8);
        System.out.println("The area of r1 is " + r1.getArea());
        System.out.println("The area of r2 is " + r2.getArea());
        System.out.println("The area of t1 is " + t1.getArea());
        System.out.println("The area of t2 is " + t2.getArea());
    }
}