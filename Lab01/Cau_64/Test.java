class Test{
    public static void main(String args[]){
        Person p1 = new Person("Nguyen Van A", "Ha Noi");
        System.out.println(p1);
        Student s1 = new Student("Nguyen Van B", "HCM", "CNTT", 2019, 1000000);
        System.out.println(s1);
        Staff st1 = new Staff("Nguyen Van C", "Can Tho", "DH KHTN", 1000000);
        System.out.println(st1);
    }
}