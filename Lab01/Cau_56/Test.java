class Test{
    public static void main(String args[]){
        Author a1 = new Author("Nguyen Van A", "ANguyen@gmai.com", 'm');
        Book b1 = new Book("Java Book", a1, 19.95, 99);
        System.out.println(b1);
    }
}