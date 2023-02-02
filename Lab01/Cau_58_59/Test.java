class Test{
    public static void main(String args[]){
        MyPoint p1 = new MyPoint(3, 0);
        MyPoint p2 = new MyPoint(0, 4);
        System.out.println(p1.distance(p2));
        System.out.println(p1.distance(5, 6));
        System.out.println(p1.distance());
        System.out.println(p1.toString());


        MyCircle c1 = new MyCircle(6, 2, 4);
        MyCircle c2 = new MyCircle(new MyPoint(2, 4), 5);

        System.out.println(c1.toString());
        System.out.println(c1.distance(c2));
    }
}