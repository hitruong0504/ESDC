class Test{
    public static void main(String args[]){
        Time t1 = new Time(9, 9, 50);
        System.out.println(t1.toString());
        t1.nextSecond();
        System.out.println(t1.toString());
        t1.nextSecond();
        System.out.println(t1.toString());
        t1.nextSecond();
        System.out.println(t1.toString());
        t1.nextSecond();
        System.out.println(t1.toString());
        t1.nextSecond();
        System.out.println(t1.toString());
        t1.nextSecond();
        System.out.println(t1.toString());
    }
}