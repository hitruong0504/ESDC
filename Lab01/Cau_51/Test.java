class Test{
    public static void main(String args[]){
        Employee e1 = new Employee(1, "Nguyen", "Van A", 1000);
        System.out.println(e1.toString());
        Employee e2 = new Employee(2, "Nguyen", "Van B", 2000);
        System.out.println(e2.toString());
        System.out.println("Annual salary of e1 is " + e1.getAnnualSalary());
        System.out.println("Annual salary of e2 is " + e2.getAnnualSalary());
        System.out.println("Salary after raise 10% of e1 is " + e1.raiseSalary(10));
        System.out.println("Salary after raise 10% of e2 is " + e2.raiseSalary(12));
    }
}