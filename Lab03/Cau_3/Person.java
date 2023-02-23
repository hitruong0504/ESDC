import java.io.Serializable;

public class Person implements Serializable {
    private String surname;
    private int count;
    private double pctwhite;

    public Person(String surname, int count, double pctwhite) {
        this.surname = surname;
        this.count = count;
        this.pctwhite = pctwhite;
    }

    public String getSurname() {
        return surname;
    }

    public int getCount() {
        return count;
    }

    public double getPctwhite() {
        return pctwhite;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Person [surname= " + surname + ", count= " + count + ", pctwhite= " + pctwhite + "]";
    }
}