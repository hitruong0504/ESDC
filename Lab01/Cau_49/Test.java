class Test{
    public static void main(String args[]){
        Circle c1 = new Circle();
        System.out.println("Radius is " + c1.getRadius());
        System.out.println("Area is " + c1.getArea());
        Circle c2 = new Circle(2.0);
        System.out.println("Radius is " + c2.getRadius());
        System.out.println("Area is " + c2.getArea());
    }
}